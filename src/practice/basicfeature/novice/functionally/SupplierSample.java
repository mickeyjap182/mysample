package practice.basicfeature.novice.functionally;

public class SupplierSample {
//    public static <S> List<? extends S> bind(java.util.function.Supplier<? extends S> supplier) {
//        List<? extends S> l = new ArrayList<>();
//        supplier.get();
//        var add = l.add(supplier.get());
//        return l;
//    }
}
class User {
    private final String name;
    User(String n) {
        name = n;
    }
    public String getUser() {
        return name;
    }
    public boolean hasPrivilege() {
        return false;
    }
}
class Admin extends User {
    Admin(String n) {
        super(n);
    }
    @Override
    public boolean hasPrivilege() {
        return true;
    }

}