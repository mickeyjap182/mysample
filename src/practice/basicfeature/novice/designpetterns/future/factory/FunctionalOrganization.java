package practice.basicfeature.novice.designpetterns.future.factory;

/** 機能横断組織 */
public class FunctionalOrganization implements Organizer {
    @Override
    public void declare(String message) {
        System.out.println(String.format("functional organization. : %s", message));
    }
}
