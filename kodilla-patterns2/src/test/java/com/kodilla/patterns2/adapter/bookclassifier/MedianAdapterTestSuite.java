package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<BookA> books = new HashSet<>();
        books.add(new BookA(
                "Henryk Sienkiewicz",
                "Potop",
                1980,
                "2134129038"
        ));
        books.add(new BookA(
                "Adam Mickiewicz",
                "Pan Tadeusz",
                1960,
                "34523453245"
        ));
        books.add(new BookA(
                "Homer",
                "Odyseja",
                1898,
                "32452134"
        ));
        //When
        int medianOfPublicationYear = medianAdapter.publicationYearMedian(books);
        //Then
        System.out.println(medianOfPublicationYear);
        assertEquals(1960, medianOfPublicationYear);
    }
}