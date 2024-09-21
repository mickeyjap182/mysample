package practice.basicfeature.ui.lib.time;

public abstract class Time {

    abstract static class Builder<T extends Builder<T>>{

        protected Builder() {

        }
        abstract public Time build();
        abstract protected T me();
    }

    Time(Builder<?> builder) {

    }
}
