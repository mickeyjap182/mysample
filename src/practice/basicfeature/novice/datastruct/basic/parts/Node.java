package practice.basicfeature.novice.datastruct.basic.parts;

public class Node {
    public Pointer next;
    public Pointer prev;
    public Node(Pointer lnext) {
        next = lnext;
        prev = null;
    }
    public Node(Pointer lnext, Pointer lprev) {
        next = lnext;
        prev = lprev;
    }

    public boolean hasNext() {
        return next != null;
    }
}
