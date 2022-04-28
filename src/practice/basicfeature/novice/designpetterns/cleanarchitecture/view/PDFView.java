package practice.basicfeature.novice.designpetterns.cleanarchitecture.view;

import practice.basicfeature.novice.designpetterns.solid.o.before.View;

public class PDFView implements View {

    private String title;
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(String.format("PDFView: %s", title));
    }
}
