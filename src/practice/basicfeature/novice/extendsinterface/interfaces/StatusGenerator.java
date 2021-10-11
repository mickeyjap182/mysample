package practice.basicfeature.novice.extendsinterface.interfaces;

import practice.basicfeature.novice.extendsinterface.parent.Status;

public interface StatusGenerator<T, R> extends Generator {
    /**
     * create new Status
     * @return
     */
    public Status newStatus(T type);
    public R getStatusIdentifier(T type);
}
