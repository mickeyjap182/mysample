package practice.basicfeature.novice.designpetterns.solid.i.after;

abstract class Controller {

    public Controller(UseCase useCase) {
        this.setUseCase(useCase);
    }
    abstract protected void setUseCase(UseCase usecase);
    abstract public Presenter dispatch();
}
