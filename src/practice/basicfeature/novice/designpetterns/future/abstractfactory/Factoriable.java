package practice.basicfeature.novice.designpetterns.future.abstractfactory;

public interface Factoriable {
    // factoryできるやつ
    // factory種類判別

    public int getKind();
    enum TYPE {
        ORGNAIZE(1),
        ROLE(2);

        int code;
        TYPE(int code) {
            this.code = code;
        }
        int getCode() {
            return code;
        }

    }

}
