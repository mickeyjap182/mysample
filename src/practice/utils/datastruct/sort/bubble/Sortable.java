package practice.utils.datastruct.sort.bubble;

public interface Sortable<_type> {
    default public _type sort(_type aa) {
        return (_type) null;
    }
}
