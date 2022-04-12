package practice.utils.logger;

public class Pattern {
    int id;
    String code;
    String detail;
    public Pattern(int id, String code, String detail) {
        this.id = id;
        this.code = code;
        this.detail = detail;
    }
    public int getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getDetail() {
        return detail;
    }
}
