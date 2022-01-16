package practice.basicfeature.algorithm.searchsample;

import java.util.*;

public class LongValueGenerator implements Iterable<Long>, Iterator<Long> {

    private Random r = new Random();
    private Map uniqueMap = new HashMap<>();
    private Integer size;

    public LongValueGenerator(Integer size) {
        this.size = size;
    }

    @Override
    public Iterator<Long> iterator() {
        return this;

    }

    @Override
    public Long next() {
        // TODO null is not better?
        if (!this.hasNext()) return null;
        Long value;

        // TODO loop is not beatuiful?
        for (value = r.nextLong(); uniqueMap.containsKey(value); value = r.nextLong()) {
            // nothing to do...
        }
        uniqueMap.put(value,value);
        return value;
    }

    @Override
    public boolean hasNext() {
        return uniqueMap.size() < size;
    }

    // default void remove(); // @Override
    // default void forEachRemaining(Consumer<? super E> action); @Override
}
