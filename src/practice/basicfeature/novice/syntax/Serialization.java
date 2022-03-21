package practice.basicfeature.novice.syntax;

import java.io.Serializable;

public class Serialization {
    public static class Memo implements Serializable {
        private String title;
        private String body;
        transient private String secret;

        final public static long serialVersionUID =1;

        public Memo(String title, String body, String secret) {
        }

        public String getTitle() {
            return title;
        }

        public String getBody() {
            return body;
        }

        public String getSecret() {
            return secret;
        }
    }

    public void execute() {
        Memo m = new Memo("memo1", "test of serializable", "password");

    }
}
