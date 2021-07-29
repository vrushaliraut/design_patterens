package RunningProblemStatement.models;

import RunningProblemStatement.controller.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

//This class represents the Library which is responsible for storing and searching the books.
@RunWith(MockitoJUnitRunner.class)
class LibraryTest {
    Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testShouldAddBookToLibrary() {
        Book book = new Book(1, "Test Book", "DS");

        Assertions.assertTrue(library.addBook(book));
        Assertions.assertEquals(1, library.getNumberOfBooks());
    }

    @Test
    void testShouldFindBookFromLibrary() {
        Book book = new Book(1, "Test Book", "DS");
        Book book2 = new Book(2, "Test Book 2", "DS");

        Assertions.assertTrue(library.addBook(book));
        Assertions.assertTrue(library.addBook(book2));

        Assertions.assertEquals(book2, library.find(2));
    }

    @Test
    void testShouldNotAddDuplicateBookToLibrary() {
        Book book = new Book(1, "Test Book", "DS");
        Book book1 = new Book(1, "Test Book", "DS");

        Assertions.assertTrue(library.addBook(book));

        Assertions.assertFalse(library.addBook(book1));
        Assertions.assertEquals(library.getNumberOfBooks(), 1);
    }

}