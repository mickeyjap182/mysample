package practice.basicfeature.novice.monkey11;

interface PrivateIf {

    /**
     * Java11 private method in interface
     * @return
     */
    private String getSelfClassName() {
        return PrivateIf.class.getName();

    }

    default void initialize() {
        System.out.printf("=== %s ===\n", getSelfClassName());
    }

}
