package practice.basicfeature.novice.securedesign.users.entities.users;

import practice.basicfeature.novice.securedesign.users.entities.User;
import practice.basicfeature.novice.securedesign.users.values.UserName;

public class Member extends User {
    Member(final Long id, final UserName userName) {
        super(id, userName);
    }
}
