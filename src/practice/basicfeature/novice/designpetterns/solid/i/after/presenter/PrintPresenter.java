package practice.basicfeature.novice.designpetterns.solid.i.after.presenter;

import practice.basicfeature.novice.designpetterns.solid.i.after.Presenter;
import practice.basicfeature.novice.designpetterns.solid.i.after.View;
import practice.basicfeature.novice.designpetterns.solid.i.after.view.PDFView;

public class PrintPresenter implements Presenter {

    @Override
    public View getView() {
        return new PDFView();
    }

    @Override
    public void render(View view) {
        view.print();
    }
}
