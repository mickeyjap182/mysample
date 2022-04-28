package practice.basicfeature.novice.designpetterns.cleanarchitecture;

import practice.basicfeature.novice.designpetterns.solid.o.before.Presenter;

public interface UseCase {
    public boolean execute();
    public Presenter getPresenter();
}
