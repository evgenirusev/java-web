package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public boolean doesUserExist(String username) {
        return this.users
                .stream()
                .anyMatch(t -> t.getUsername()
                        .equals(username));
    }
    public List<User> getAllUsers() {
        return this.users;
    }

    public User getByUsername(String username) {
        return this
                .getAllUsers()
                .stream()
                .filter(x -> x.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean areCredentialsValid(String username, String password) {
        return this.doesUserExist(username) &&
                this.getByUsername(username).getPassword().equals(password);
    }
}
