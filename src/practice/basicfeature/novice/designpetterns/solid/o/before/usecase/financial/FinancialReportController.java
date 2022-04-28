package practice.basicfeature.novice.designpetterns.solid.o.before.usecase.financial;

import practice.basicfeature.novice.designpetterns.solid.o.before.Controller;
import practice.basicfeature.novice.designpetterns.solid.o.before.Presenter;
import practice.basicfeature.novice.designpetterns.solid.o.before.View;

public class FinancialReportController implements Controller {

    private Presenter presenter;

    public FinancialReportController(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean dispatch() {
        // save a record.
        FinancialReportInteractor report =  new FinancialReportInteractor(new FinancialDatabase());
        report.save();
        // output a report.
        View view = presenter.getView();
        view.setTitle(report.getHeader().getName());
        view.print();
        return true;
    }
}
