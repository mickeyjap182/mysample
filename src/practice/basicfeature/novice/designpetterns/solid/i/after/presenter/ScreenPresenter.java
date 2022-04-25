package practice.basicfeature.novice.designpetterns.solid.i.after.presenter;

import practice.basicfeature.novice.designpetterns.solid.i.after.Presenter;
import practice.basicfeature.novice.designpetterns.solid.i.after.View;
import practice.basicfeature.novice.designpetterns.solid.i.after.view.WebView;

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
