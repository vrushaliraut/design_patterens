package RunningProblemStatement.controller;

import RunningProblemStatement.models.Book;
import RunningProblemStatement.models.User;

public class OnlineReaderSystem {
    UserManager userManager;
    Library library;
    Display display;

    private Book activeBook;
    private User activeUser;

    public OnlineReaderSystem() {
        userManager = new UserManager();
        library = new Library();
        display = new Display();
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Display getDisplay(User user1) {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void addActiveUser(User user) {
        activeUser = user;
        display.displayUser(user);
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveBook(Book book) {
        activeBook = book;
        display.displayBook(book);
    }
}
