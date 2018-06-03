package com.kodilla.good.patterns.challenges;

import java.util.HashSet;
import java.util.Set;

public class UserDataBase {
    private static Set<User> setOfUsers = new HashSet<>();

    public static void addUser(User user) {
        setOfUsers.add(user);
    }

    public static Set<User> getSetOfUsers() {
        return setOfUsers;
    }
}
