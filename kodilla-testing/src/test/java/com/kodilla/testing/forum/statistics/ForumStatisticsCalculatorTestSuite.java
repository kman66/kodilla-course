package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsCalculatorTestSuite {

    private ArrayList<String> generateList(int size){
        ArrayList<String> resultList = new ArrayList<String>();
        for(int i=0; i<size; i++){
            resultList.add("Test");
        }

        return resultList;
    }

    @Test
    public void testCalculateAdvStatisticsWhenUsersZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatisticsCalculator forumStatisticsCalculator = new ForumStatisticsCalculator();
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>());
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double avgPostsPerUser = forumStatisticsCalculator.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatisticsCalculator.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatisticsCalculator.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(0, avgPostsPerUser, 0.01);
        Assert.assertEquals(0, avgCommentsPerUser, 0.01);
        Assert.assertEquals(0, avgCommentsPerPost, 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWhenPostsZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatisticsCalculator forumStatisticsCalculator = new ForumStatisticsCalculator();
        when(statisticsMock.userNames()).thenReturn(generateList(100));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double avgPostsPerUser = forumStatisticsCalculator.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatisticsCalculator.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatisticsCalculator.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(0, avgPostsPerUser, 0.01);
        Assert.assertEquals(0, avgCommentsPerUser, 0.01);
        Assert.assertEquals(0, avgCommentsPerPost, 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWhenCommentsZero(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatisticsCalculator forumStatisticsCalculator = new ForumStatisticsCalculator();
        when(statisticsMock.userNames()).thenReturn(generateList(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);

        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double avgPostsPerUser = forumStatisticsCalculator.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatisticsCalculator.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatisticsCalculator.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(10, avgPostsPerUser, 0.01);
        Assert.assertEquals(0, avgCommentsPerUser, 0.01);
        Assert.assertEquals(0, avgCommentsPerPost, 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWhenCommentsLessThanPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatisticsCalculator forumStatisticsCalculator = new ForumStatisticsCalculator();
        when(statisticsMock.userNames()).thenReturn(generateList(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);

        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double avgPostsPerUser = forumStatisticsCalculator.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatisticsCalculator.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatisticsCalculator.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(10, avgPostsPerUser, 0.01);
        Assert.assertEquals(5, avgCommentsPerUser, 0.01);
        Assert.assertEquals(0.5, avgCommentsPerPost, 0.01);
    }

    @Test
    public void testCalculateAdvStatisticsWhenCommentsMoreThanPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatisticsCalculator forumStatisticsCalculator = new ForumStatisticsCalculator();
        when(statisticsMock.userNames()).thenReturn(generateList(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);

        forumStatisticsCalculator.calculateAdvStatistics(statisticsMock);

        //When
        double avgPostsPerUser = forumStatisticsCalculator.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatisticsCalculator.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatisticsCalculator.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(10, avgPostsPerUser, 0.01);
        Assert.assertEquals(20, avgCommentsPerUser, 0.01);
        Assert.assertEquals(2, avgCommentsPerPost, 0.01);
    }
}
