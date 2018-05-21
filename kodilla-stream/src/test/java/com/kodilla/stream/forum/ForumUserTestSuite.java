package com.kodilla.stream.forum;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ForumUserTestSuite {
    @Test
    public void testGetLocationsOfFriends() {
        //Given
        //Create users
        List<ForumUser> listOfUsers = createAndGetSomeUsers();

        //When
        List<ForumUser> listOfUsersWithRelations = makeRelations(listOfUsers);

        //Then
        //user1 has 3 friends with following locations:
        //   user3:  "Key West"
        //   user7:  "Washington"
        //   user10: "Miami"
        Assert.assertEquals(3, listOfUsersWithRelations.get(0).getLocationsOfFriends().size());
        Assert.assertTrue(listOfUsersWithRelations.get(0).getLocationsOfFriends().contains("Key West"));
        Assert.assertTrue(listOfUsersWithRelations.get(0).getLocationsOfFriends().contains("Washington"));
        Assert.assertTrue(listOfUsersWithRelations.get(0).getLocationsOfFriends().contains("Miami"));
        Assert.assertFalse(listOfUsersWithRelations.get(0).getLocationsOfFriends().contains("Orlando"));
    }

    @Test
    public void testGetLocationsOfFriendsOfFriends() {
        //Given
        //Create users
        List<ForumUser> listOfUsers = createAndGetSomeUsers();

        //When
        List<ForumUser> listOfUsersWithRelations = makeRelations(listOfUsers);

        //Then
        //user1 has 3 friends with following friends and their locations:
        //   user3:  user1: - should be skipped ("this" in context of user1)
        //           user7: "Washington"
        //           user2: "Miami"
        //           user9: "Washington" - duplicated, should be skipped
        //   user7:  user1: - should be skipped ("this" in context of user1)
        //           user3: "Key West"
        //   user10: user1: - should be skipped ("this" in context of user1)
        Assert.assertEquals(3, listOfUsersWithRelations.get(0).getLocationsOfFriendsOfFriends().size());
        Assert.assertTrue(listOfUsersWithRelations.get(0).getLocationsOfFriendsOfFriends().contains("Key West"));
        Assert.assertTrue(listOfUsersWithRelations.get(0).getLocationsOfFriendsOfFriends().contains("Washington"));
        Assert.assertTrue(listOfUsersWithRelations.get(0).getLocationsOfFriendsOfFriends().contains("Miami"));
        Assert.assertFalse(listOfUsersWithRelations.get(0).getLocationsOfFriendsOfFriends().contains("Orlando"));
    }

    private List<ForumUser> createAndGetSomeUsers(){
        List<ForumUser> users = new ArrayList<>();
        users.add(new ForumUser("alan01", "Alan Kosovsky", "Washington"));
        users.add(new ForumUser("ethanreard", "Ethan Reard", "Miami"));
        users.add(new ForumUser("eRiK", "Erik Hull", "Key West"));
        users.add(new ForumUser("booth", "Mya Booth", "Washington"));
        users.add(new ForumUser("nicole1987", "Nicole Lee", "Orlando"));
        users.add(new ForumUser("nobody", "Briana Williams", "Miami"));
        users.add(new ForumUser("bigmac", "Robert Macdonald", "Washington"));
        users.add(new ForumUser("thebigone", "Clay Small", "Orlando"));
        users.add(new ForumUser("user121212", "Marisa Frank", "Washington"));
        users.add(new ForumUser("lawyer", "Lexie John", "Miami"));

        return users;
    }

    private List<ForumUser> makeRelations(List<ForumUser> list){
        List<ForumUser> resultList = new ArrayList<>(list);

        //Create relations for user1
        resultList.get(0).addFriend(resultList.get(2));
        resultList.get(0).addFriend(resultList.get(6));
        resultList.get(0).addFriend(resultList.get(9));
        //Create relations for user3
        resultList.get(2).addFriend(resultList.get(0));
        resultList.get(2).addFriend(resultList.get(6));
        resultList.get(2).addFriend(resultList.get(1));
        resultList.get(2).addFriend(resultList.get(8));
        //Create relations for user7
        resultList.get(6).addFriend(resultList.get(0));
        resultList.get(6).addFriend(resultList.get(2));
        //Create relations for user10
        resultList.get(9).addFriend(resultList.get(0));
        //Create relations for user2
        resultList.get(1).addFriend(resultList.get(2));
        //Create relations for user9
        resultList.get(8).addFriend(resultList.get(2));

        return resultList;
    }
}