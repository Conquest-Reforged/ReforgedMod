package com.conquestrefabricated.client.gui.search.query;

/**
 * @author dags <dags@dags.me>
 */
public class Result<T> implements Comparable<Result<T>> {

    private static final Result<?> EMPTY = new Result<>(null, Integer.MAX_VALUE, Integer.MAX_VALUE);

    private final T result;
    private final int rank;
    private final double score;

    public Result(T result, int rank, double score) {
        this.result = result;
        this.rank = rank;
        this.score = score;
    }

    public T getResult() {
        return result;
    }

    public int getRank() {
        return rank;
    }

    public boolean isPresent() {
        return this != EMPTY;
    }

    @Override
    public int compareTo(Result<T> result) {
        if (this.rank == result.rank) {
            if (this.score == result.score) {
                return Integer.compare(this.result.hashCode(), result.result.hashCode());
            }
            return Double.compare(this.score, result.score);
        }
        return Integer.compare(this.rank, result.rank);
    }

    @Override
    public String toString() {
        return String.format("%s, rank=%s, score=%s", result, rank, score);
    }

    @SuppressWarnings("unchecked")
    public static <T> Result<T> empty() {
        return (Result<T>) EMPTY;
    }
}
