package practice.basicfeature.novice.designpetterns.feature.observer;

public interface Subject {
    public enum STATUS {
        NEWS,
        ALL_NEWS,
    }
    void addSubscriber(Observer s);
    public void removeSubscriber(Observer s);
    public void notify(Observer s);
    public void notifyAllSubscriber();
    public void changeTo(Subject.STATUS status);
}
