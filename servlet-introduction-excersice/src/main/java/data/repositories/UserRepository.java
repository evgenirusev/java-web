package data.repositories;

import data.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void addUser(User user) {
        this.users.put(user.getUsername(), user);
    }

    public boolean doesUserExist(String username) {
        return this.users.values()
                .stream()
                .anyMatch(t -> t.getUsername()
                        .equals(username));
    }
}
