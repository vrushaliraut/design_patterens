package RunningProblemStatement.models;

import java.util.Objects;

public class User {
    private int userId;
    private String name;
    private String details;

    public User() {
    }

    public User(int userId, String name, String details) {
        this.userId = userId;
        this.name = name;
        this.details = details;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(name, user.name) && Objects.equals(details, user.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, details);
    }
}
