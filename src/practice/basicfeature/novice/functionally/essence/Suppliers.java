package practice.basicfeature.novice.functionally.essence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
/**
 * no arg, return reteral value
 */
public class Suppliers {

    public void execute() {
        Supplier<Object> sup = getSupplier("Hello , my dog!");
        System.out.println(sup.get());
        Supplier adm = getSupplier(new Admin("Bob"));
        List<User> admin = bind(adm);
        System.out.println(((Admin)admin.get(0)).hasPrivilege());
        Supplier usr = getSupplier(new User("Ellen"));
        List<User> user = bind(usr);
        System.out.println(((User)user.get(0)).hasPrivilege());
    }

    // evaluation
    public static Supplier<Object> getSupplier(Object message) {
        return new Supplier() {
           @Override
           public Object get() {
               return (Object) message;
           }
        };
    }
    public static <S> List<? extends S> bind(Supplier<? extends S> supplier) {
        List<S> list = new ArrayList<>();
        S value = supplier.get();
        list.add(value);
        return list;
    }
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