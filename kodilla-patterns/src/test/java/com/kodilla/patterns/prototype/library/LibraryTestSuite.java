package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;

public class LibraryTestSuite {
    private static Book quoVadis;
    private static Book dziady;
    private static Book zemsta;

    @BeforeClass
    public static void generateBooks() {
        quoVadis = new Book("Quo vadis", "Henryk Sienkiewicz", LocalDate.of(1985, 5, 13));
        dziady = new Book("Dziady", "Adam Mickieicz", LocalDate.of(1977, 1, 16));
        zemsta = new Book("Zemsta", "Aleksander Fredro", LocalDate.of(1966, 11, 1));
    }

    private Library generateLibraryInstance() {
        Library library = new Library("Biblioteka glowna");
        library.getBooks().add(quoVadis);
        library.getBooks().add(dziady);
        library.getBooks().add(zemsta);

        return library;
    }

    @Test
    public void testGetBooks() {
        //Given
        Library library = generateLibraryInstance();

        //When
        Set<Book> resultBooks = library.getBooks();

        //Then
        Assert.assertEquals(3, resultBooks.size());
        Assert.assertTrue(resultBooks.contains(quoVadis));
        Assert.assertTrue(resultBooks.contains(dziady));
        Assert.assertTrue(resultBooks.contains(zemsta));
    }

    @Test
    public void testShallowCopy() {
        //Given
        Library library = generateLibraryInstance();

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Biblioteka miejska");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(dziady);

        //Then
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, clonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks(), clonedLibrary.getBooks());
    }

    @Test
    public void testDeepCopy() {
        //Given
        Library library = generateLibraryInstance();

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.deepCopy();
            clonedLibrary.setName("Biblioteka miejska");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(dziady);

        //Then
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(3, clonedLibrary.getBooks().size());
        Assert.assertNotEquals(library.getBooks(), clonedLibrary.getBooks());
    }
}
