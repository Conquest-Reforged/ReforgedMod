package com.conquestreforged.client.gui.search.query;

import java.util.regex.Pattern;

/**
 * @author dags <dags@dags.me>
 */
public class Query {

    private final String raw;
    private final String args;
    private final Pattern tags;
    private final Pattern ordered;
    private final Pattern unordered;

    public Query(String input) {
        input = input.trim().toLowerCase();

        String[] split = input.split(" ");
        StringBuilder args = new StringBuilder();
        StringBuilder tagBuilder = new StringBuilder();
        StringBuilder queryBuilder = new StringBuilder();
        StringBuilder unorderedQueryBuilder = new StringBuilder();

        for (String token : split) {
            if (token.isEmpty()) {
                continue;
            }
            if (token.startsWith("#")) {
                tagBuilder.append("(?=.*").append(Pattern.quote(token)).append(")");
            } else {
                if (queryBuilder.length() == 0) {
                    queryBuilder.append("(^").append(Pattern.quote(token)).append(")");
                } else {
                    queryBuilder.append("(.*").append(Pattern.quote(token)).append(")");
                }
                args.append(args.length() > 0 ? " " : "").append(token);
                unorderedQueryBuilder.append("(?=.*").append(Pattern.quote(token)).append(")");
            }
        }

        this.raw = input;
        this.args = args.toString();
        this.tags = Pattern.compile(tagBuilder.toString(), Pattern.CASE_INSENSITIVE);
        this.ordered = Pattern.compile(queryBuilder.toString(), Pattern.CASE_INSENSITIVE);
        this.unordered = Pattern.compile(unorderedQueryBuilder.toString(), Pattern.CASE_INSENSITIVE);
    }

    public <T> Result<T> test(Entry<T> entry) {
        String key = entry.getName();
        String tag = entry.getTags();

        if (tags.matcher(tag).find()) {
            double score = Levenshtein.distance(args, key);

            if (ordered.matcher(key).find()) {
                int rank = 0;
                return new Result<>(entry.getValue(), rank, score);
            }

            if (unordered.matcher(key).find()) {
                int rank = 1;
                return new Result<>(entry.getValue(), rank, score);
            }

            return new Result<>(entry.getValue(), 2, score);
        }
        return Result.empty();
    }
}
