package practice.basicfeature.filesystem;

import javax.print.DocFlavor;
import java.util.Optional;


public class File extends FileSystem implements Readable, Writeable, Executable {
    public String name;
    public Optional<Directory> directory;
    public Optional<User>  user = new Optional<>();
    public Optional<Group> group = new Optional<>();
    public Optional<Other> other = new Optional<>();

    public String username() {
        SomeOne s = new User();
        s.setName("aaaa");
        AnyBody a = new AnyBody();

        user.ifPresent(v -> System.out.println("aaa"));
        user.orElseGet(a).getName();
//        String ret = user.ifPresentOrElse(v -> v.getName()
//        , s::getName
//        );
    }

    public String getUserName() {
        AnyBody any = new AnyBody();
        return "";
//        return this.user.orElse("aaaa").name;
    }

    public String getPermissionChars() {
        StringBuilder sb = new StringBuilder("rwx");
        return sb.toString();
    }
}
