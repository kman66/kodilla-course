package com.kodilla.patterns2.adapter.bookclassifier.libraryb;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

public class Statistics implements BookStatistics {

    @Override
    public int averagePublicationYear(Map<BookSignature, BookB> books) {
        if (books.size() == 0) return 0;
        int sum = 0;
        sum = books.values().stream()
                .mapToInt(b -> b.getYearOfPublication())
                .sum();
        return sum / books.size();
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, BookB> books) {
        if (books.size() == 0) return 0;
        int[] years;
        years = books.values().stream()
                .mapToInt(b -> b.getYearOfPublication())
                .toArray();
        Arrays.sort(years);
        if (years.length % 2 == 0) {
            return years[(int)(years.length / 2 + 0.5)];
        } else {
            return years[years.length / 2];
        }
    }
}
