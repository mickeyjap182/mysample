package practice.basicfeature.novice.designpetterns.cleanarchitecture;

import practice.basicfeature.novice.designpetterns.solid.o.before.Presenter;

abstract class Controller {

    public Controller(UseCase useCase) {
        this.setUseCase(useCase);
    }
    abstract protected void setUseCase(UseCase usecase);
    abstract public Presenter dispatch();
}
