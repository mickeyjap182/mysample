package practice.basicfeature.novice.designpetterns.future.factory;

public interface Organizer {
    enum TYPE  {
        FUNCTIONAL(1),
        BUSSINESSUNIT(2);

        int code;
        TYPE(int code) {
            this.code = code;
        }
        int getCode() {
            return code;
        }
    }

    default void declare(String message) {
        System.out.println(String.format("dummy declare.(no organization ) : %s", message));
    }
}
