//package practice.basicfeature.filesystem;
//
//import javax.print.DocFlavor;
//import java.util.Optional;
//import practice.basicfeature.filesystem.User;
//
//
//public class File extends FileSystem implements Readable, Writeable, Executable {
//    public String name;
//    public Optional<Directory> directory;
//    public Optional user  = Optional.of(new User());
//    public Optional<Group> group = new Optional<>();
//    public Optional<Other> other = new Optional<>();
//
//    public String make(String name){
//        Directory d = new Directory();
//        return "";
//    }
//    public String username() {
//        SomeOne s = new User();
//        s.setName("aaaa");
//        AnyBody a = new AnyBody();
//
//        user.ifPresent(v -> System.out.println("aaa"));
////        user.orElseGet(a).getName(); // interfaceof SomeOne
////        String ret = user.ifPresentOrElse(v -> v.getName()
////        , s::getName
////        );
//
//        return "";
//    }
//
//    public String getUserName() {
//        AnyBody any = new AnyBody();
//        return "";
////        return this.user.orElse("aaaa").name;
//    }
//
//    public String getPermissionChars() {
//        StringBuilder sb = new StringBuilder("rwx");
//        return sb.toString();
//    }
//}
