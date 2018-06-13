package com.kodilla.spring.library;

import org.springframework.stereotype.Repository;

@Repository
public final class LibraryDbController {
    public String saveData() {
        return "Saving data to the database.";
    }

    public String loadData() {
        return "Loading data from the database";
    }
}
