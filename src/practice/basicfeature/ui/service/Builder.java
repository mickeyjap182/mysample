package practice.basicfeature.ui.service;

/**
 * TODO デザインパターン向けIF パラメータや型をつけられないなら消す、モデリングができなければ
 * @param <T>
 */
public interface Builder<T> {
    T build();
}
