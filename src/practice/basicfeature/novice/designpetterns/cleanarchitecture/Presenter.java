package practice.basicfeature.novice.designpetterns.cleanarchitecture;

import practice.basicfeature.novice.designpetterns.solid.o.before.View;

public interface Presenter {
    public View getView();
    public void render(View view);
}
