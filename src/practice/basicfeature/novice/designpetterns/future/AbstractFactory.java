package practice.basicfeature.novice.designpetterns.future;

public interface AbstractFactory<T, _TYPE> {
    public T create(_TYPE type);
}
