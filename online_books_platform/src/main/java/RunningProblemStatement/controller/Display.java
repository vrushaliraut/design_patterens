package RunningProblemStatement.controller;

import RunningProblemStatement.models.Book;
import RunningProblemStatement.models.User;

public class Display {

    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;


    public void turnPageForward() {
        pageNumber++;
        System.out.println("Turning forward to page no " + pageNumber + " of book having title " + activeBook.getTitle());
        refreshPage();
    }

    public void turnPageBackward() {
        pageNumber--;
        System.out.println("Turning backward to page no " + pageNumber + " of book having title " + activeBook.getTitle());
        refreshPage();
    }

    public void displayUser(User user) {
        activeUser = user;
        refreshUserName();
    }

    public void displayBook(Book book) {
        pageNumber = 0;
        activeBook = book;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    private void refreshUserName() {
        System.out.println("User name " + activeUser.getName() + "is refreshed");
    }

    private void refreshTitle() {
        System.out.println("User name " + activeUser.getName() + "is refreshed");
    }


    private void refreshDetails() {
        System.out.println("Details of the book " + activeBook.getTitle() + " refreshed");
    }

    public void refreshPage() {
        /* updated page display */
        System.out.println("Page no " + pageNumber + " refreshed");
    }
}
