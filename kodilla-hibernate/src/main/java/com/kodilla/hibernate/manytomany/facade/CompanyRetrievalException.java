package com.kodilla.hibernate.manytomany.facade;

public class CompanyRetrievalException extends Exception {
    public static String ERR_NOT_FOUND = "No data found for given name";

    public CompanyRetrievalException(String message) {
        super(message);
    }
}
