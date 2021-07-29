package RunningProblemStatement.controller;

import RunningProblemStatement.models.Book;

import java.util.HashMap;

//This class represents the Library which is responsible for storing and searching the books.
public class Library {
    private HashMap<Integer, Book> books;

    public Library() {
        this.books = new HashMap<Integer, Book>();
    }

    public boolean addBook(Book book) {
        if (books.containsKey(book.getBookId())) {
            return false;
        }
        books.put(book.getBookId(), book);
        return true;
    }

    public Book find(int id) {
        return books.get(id);
    }

    public int getNumberOfBooks() {
        return books.size();
    }
}
