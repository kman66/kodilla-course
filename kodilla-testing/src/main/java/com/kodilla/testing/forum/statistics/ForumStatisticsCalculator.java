package com.kodilla.testing.forum.statistics;

public class ForumStatisticsCalculator {
    private int forumUsers;
    private int forumPosts;
    private int forumComments;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        // retrieve values
        forumUsers = statistics.userNames().size();
        forumPosts = statistics.postsCount();
        forumComments = statistics.commentsCount();

        // calculate averages
        avgPostsPerUser = 0;
        avgCommentsPerUser = 0;
        avgCommentsPerPost = 0;

        if(forumUsers > 0){
            avgPostsPerUser = (double) forumPosts/forumUsers;
            avgCommentsPerUser = (double) forumComments/forumUsers;
        }

        if(forumPosts > 0){
            avgCommentsPerPost = (double) forumComments/forumPosts;
        }
    }

    public void showStatistics(){
        System.out.println("Number of users in forum: " + forumUsers);
        System.out.println("Number of posts in forum: " + forumPosts);
        System.out.println("Number of comments in forum: " + forumComments);
        System.out.println("Average number of posts per user: " + avgPostsPerUser);
        System.out.println("Average number of comments per user: " + avgCommentsPerUser);
        System.out.println("Average number of comment per post:: " + avgCommentsPerPost);
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
