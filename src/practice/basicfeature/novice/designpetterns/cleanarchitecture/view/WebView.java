package practice.basicfeature.novice.designpetterns.cleanarchitecture.view;

import practice.basicfeature.novice.designpetterns.solid.o.before.View;

public class WebView implements View {

    private String title;
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(String.format("WebView: %s", title));
    }
}
