package com.conquestrefabricated.client.gui.search.query;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dags <dags@dags.me>
 */
public class Index<T> {

    private final List<Entry<T>> entries;
    private final float fuzz = 0.25F;

    private Index(List<Entry<T>> entries) {
        this.entries = entries;
    }

    public List<T> search(String input, int limit) {
        return parallelSearch(input, limit).map(Result::getResult).collect(Collectors.toList());
    }

    public List<Result<T>> find(String input, int limit) {
        return parallelSearch(input, limit).collect(Collectors.toList());
    }

    public void parallelSearch(String input, int limit, Consumer<Result<T>> consumer) {
        parallelSearch(input, limit).forEachOrdered(consumer);
    }

    public Stream<Result<T>> parallelSearch(String input, int limit) {
        if (input.isEmpty()) {
            return Stream.empty();
        }

        Query query = new Query(input);
        int fuzzLimit = Math.round(limit * fuzz);
        AtomicInteger fuzzCounter = new AtomicInteger(0);
        Predicate<Result<?>> fuzzFilter = result -> result.getRank() < 2 || fuzzCounter.addAndGet(1) < fuzzLimit;

        return entries.parallelStream()
                .map(query::test)
                .filter(Result::isPresent)
                .sorted()
                .limit(limit)
                .filter(fuzzFilter);
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {

        private final List<Entry<T>> entries = new LinkedList<>();

        public Builder<T> with(T value, String text, Collection<String> tags) {
            StringBuilder tagBuilder = new StringBuilder();
            for (String tag : tags) {
                tagBuilder.append('#').append(tag);
            }
            entries.add(new Entry<>(value, text, tagBuilder.toString()));
            return this;
        }

        public Index<T> build() {
            return new Index<>(Collections.unmodifiableList(new ArrayList<>(entries)));
        }
    }
}
