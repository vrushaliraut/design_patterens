package RunningProblemStatement.controller;

import RunningProblemStatement.models.User;

import java.util.HashMap;

// This class represents the UserManager which is responsible for managing the users, their membership etc.
public class UserManager {

    private volatile HashMap<Integer, User> users;

    public UserManager() {
        users = new HashMap<Integer, User>();
    }

    public boolean addUser(User user) {
        int userId = user.getUserId();
        if (users.containsKey(userId)) {
            return false;
        }
        users.put(userId, user);
        return true;
    }

    public int getUsers() {
        return users.size();
    }

    public boolean remove(User user) {
        return remove(user.getUserId());
    }

    private boolean remove(int userId) {
        if (!users.containsKey(userId)) {
            return false;
        }
        users.remove(userId);
        return true;
    }
}
