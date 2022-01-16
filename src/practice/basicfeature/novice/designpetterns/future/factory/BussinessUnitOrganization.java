package practice.basicfeature.novice.designpetterns.future.factory;


/** 事業部制組織 */
public class BussinessUnitOrganization implements Organizer {
    @Override
    public void declare(String message) {
        System.out.println(String.format("bussiness unit organization. : %s", message));
    }
}
