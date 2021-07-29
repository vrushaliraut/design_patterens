package RunningProblemStatement;

import RunningProblemStatement.controller.OnlineReaderSystem;
import RunningProblemStatement.models.Book;
import RunningProblemStatement.models.User;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start the Book library management app");

        OnlineReaderSystem onlineReaderSystem = new OnlineReaderSystem();

        // add book
        Book dsBook = new Book(1, "Algorithms", "DS");
        Book systemDesignBook = new Book(2, "System design", "DataIntensive");

        onlineReaderSystem.getLibrary().addBook(dsBook);
        onlineReaderSystem.getLibrary().addBook(systemDesignBook);

        // add user
        User user1 = new User(1, "", "Vrushali");
        User user2 = new User(2, "", "Abhi");

        onlineReaderSystem.getUserManager().addUser(user1);
        onlineReaderSystem.getUserManager().addUser(user2);

        onlineReaderSystem.addActiveUser(user1);
        onlineReaderSystem.setActiveBook(dsBook);

        onlineReaderSystem.setActiveBook(systemDesignBook);
        onlineReaderSystem.addActiveUser(user2);

        onlineReaderSystem.getDisplay(user1).turnPageForward();
        onlineReaderSystem.getDisplay(user1).turnPageForward();
        onlineReaderSystem.getDisplay(user1).turnPageBackward();


        onlineReaderSystem.getDisplay(user2).turnPageForward();
        onlineReaderSystem.getDisplay(user2).turnPageForward();
        onlineReaderSystem.getDisplay(user2).turnPageBackward();
    }
}
