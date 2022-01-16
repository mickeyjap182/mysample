package practice.basicfeature.novice.securedesign.users.entities;

import practice.basicfeature.novice.securedesign.users.values.UserName;

import java.util.Objects;

public class User {
    final private Long id;
    final private UserName userName;

    public User(final Long id, final UserName userName) {
        this.id = id;
        this.userName = !Objects.isNull(userName) ? userName: null;
    }
}
