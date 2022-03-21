package practice.basicfeature.novice.syntax;

public class Const {
    public static class System {
        public static System BATCH = new System(0, User.SYSTEM_ADMIN);
        public static System WEB_MEMBER = new System(1, User.FREE_MEMBER);
        private System(int type, User user) {
            this.type = type;
            this.user = user;
        }
        private int type;
        private User user;

        public static class User {
            public static User SYSTEM_ADMIN = new User(1);
            public static User ADMIN = new User(10);
            public static User FREE_MEMBER = new User(20);
            public static User STANDARD_MEMBER = new User(21);
            private User(int type) {
                this.type = type;
            }
            public int type;

        }
    }
}
