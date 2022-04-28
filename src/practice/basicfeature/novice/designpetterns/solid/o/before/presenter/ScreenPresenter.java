package practice.basicfeature.novice.designpetterns.solid.o.before.presenter;

import practice.basicfeature.novice.designpetterns.solid.o.before.Presenter;
import practice.basicfeature.novice.designpetterns.solid.o.before.View;
import practice.basicfeature.novice.designpetterns.solid.o.before.view.WebView;

public class ScreenPresenter implements Presenter {

    @Override
    public View getView() {
        return new WebView();
    }

    @Override
    public void render(View view) {
        view.print();
    }
}
