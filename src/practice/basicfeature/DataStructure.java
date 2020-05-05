package practice.basicfeature;


public class DataStructure {

    public int id =  1001;
    private int  o;
    public DataStructure(int o) {
        this.o = o;
    }

    public void add(int i) {
        this.o += i;
    }

    public int get() {
        return this.o;
    }

}
