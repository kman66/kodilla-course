package com.kodilla.stream.forumuser;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ForumTestSuite {
    @Test
    public void testAddForumUser(){
        //Given
        ForumUser forumUser = new ForumUser(1, "steve", 'M',
                10, 10, 10, 2000);
        Forum forum = new Forum();

        //When
        forum.addForumUser(forumUser);

        //Then
        Assert.assertEquals(1, forum.getList().size());
    }

    @Test
    public void testExercise73(){
        //Given
        ForumUser dylan = new ForumUser(1, "dylan", 'M',
                10, 10, 10, 1990);
        ForumUser phoebe = new ForumUser(2, "phoebe", 'F',
                4, 25, 1, 1997);
        ForumUser morgan = new ForumUser(3, "morgan", 'M',
                1, 4, 7, 1991);
        ForumUser aimee = new ForumUser(4, "aimee", 'F',
                0, 29, 4, 2001);
        ForumUser ryan = new ForumUser(5, "ryan", 'M',
                0, 25, 1, 1996);
        ForumUser madelynn = new ForumUser(6, "madelynn", 'F',
                8, 25, 8, 1995);
        ForumUser giancarlo = new ForumUser(7, "giancarlo", 'M',
                21, 21, 7, 1994);

        Forum forum = new Forum();
        forum.addForumUser(dylan, phoebe, morgan, aimee, ryan, madelynn, giancarlo);

        Map<Integer, ForumUser> expectedMap = new HashMap<>();
        expectedMap.put(dylan.getId(), dylan);
        expectedMap.put(morgan.getId(), morgan);
        expectedMap.put(giancarlo.getId(), giancarlo);

        //When
        Map<Integer, ForumUser> testMap = forum.getList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> Period.between(user.getBirthDate(), LocalDate.now()).toTotalMonths() >= 240)
                .filter(user -> user.getNoOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        //Then
        Assert.assertArrayEquals(expectedMap.entrySet().toArray(), testMap.entrySet().toArray());
    }
}
