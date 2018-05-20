package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int id;
    private final String userName;
    private final char gender;
    private final LocalDate birthDate;
    private final int noOfPosts;

    public ForumUser(final int id, final String userName, final char gender, final int noOfPosts,
                     final int dayOfBirth, final int monthOfBirth, final int yearOfBirth) {
        this.id = id;
        this.userName = userName;
        this.gender = gender;
        this.noOfPosts = noOfPosts;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNoOfPosts() {
        return noOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", noOfPosts=" + noOfPosts +
                '}';
    }
}
