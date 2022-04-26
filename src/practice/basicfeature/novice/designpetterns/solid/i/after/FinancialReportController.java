package practice.basicfeature.novice.designpetterns.solid.i.after;

public class FinancialReportController extends Controller {

    UseCase useCase;

    public FinancialReportController(UseCase useCase) {
        super(useCase);
    }

    @Override
    protected void setUseCase(UseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Presenter dispatch() {
        useCase.execute();
        return useCase.getPresenter();
    }
}
