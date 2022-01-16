package practice.basicfeature.novice.securedesign.users.values;

public class UserName {
    private static final int MIN_LEN = 4;
    private static final String VALID_CHARACTERS = "[A-Za-z0-9_-]+";

    // immutable. if you set once, you can't modify anyway.
    final private String value;

    public UserName(final String value) {

        // where should it execute validator function?

        // value is correct.
        this.value = value;

    }
}
