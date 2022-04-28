package practice.basicfeature.novice.designpetterns.solid.o.before.usecase.financial;

import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.designpetterns.solid.o.before.presenter.PrintPresenter;
import practice.basicfeature.novice.designpetterns.solid.o.before.presenter.ScreenPresenter;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FinancialReportControllerTest {
    @Test
    public void before_openclosed() {

        var f = new FinancialReportController(new PrintPresenter());
        assertTrue(f.dispatch());

        var fweb = new FinancialReportController(new ScreenPresenter());
        assertTrue(fweb.dispatch());
    }

}