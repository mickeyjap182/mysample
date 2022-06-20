package practice.basicfeature.novice.designpetterns.solid.i.before;

public class OPS {
    public enum TYPE {
        OP1("op1"),
        OP2("op1"),
        OP3("op1");

        private String code;
        TYPE(String code) {
            this.code = code;
        }
        public String code() {
            return code;
        }
    }

    public String op1() {
        return TYPE.OP1.code();
    }
    public String op2() {
        return TYPE.OP2.code();
    }
    public String op3() {
        return TYPE.OP3.code();
    }
}
