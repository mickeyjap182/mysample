package practice.basicfeature.novice.designpetterns.solid.i.after.view;

import practice.basicfeature.novice.designpetterns.solid.i.after.View;

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
