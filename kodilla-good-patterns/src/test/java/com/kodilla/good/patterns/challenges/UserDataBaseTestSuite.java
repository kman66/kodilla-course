package com.kodilla.good.patterns.challenges;

import org.junit.Assert;
import org.junit.Test;

public class UserDataBaseTestSuite {
    @Test
    public void testAddUser() {
        //Given
        User johnsmith = new User("1", "John", "Smith", "johnsmith@mail.com");
        
        //When
        UserDataBase.addUser(johnsmith);
        UserDataBase.addUser(johnsmith);

        //Then
        Assert.assertEquals(1, UserDataBase.getSetOfUsers().size());
        Assert.assertTrue(UserDataBase.getSetOfUsers().contains(johnsmith));
    }
}
