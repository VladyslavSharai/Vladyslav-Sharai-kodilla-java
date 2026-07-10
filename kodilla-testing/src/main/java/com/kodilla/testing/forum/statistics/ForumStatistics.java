package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        if(statistics == null){
            return;
        }

        List<String> usersList = statistics.usersNames();
        this.usersCount = (usersList != null) ? usersList.size() : 0;
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        if(usersCount > 0){
            this.averagePostsPerUser = (double)  postsCount / usersCount;
            this.averageCommentsPerUser = (double)  commentsCount / usersCount;
        }
        else {
            this.averagePostsPerUser = 0;
            this.averageCommentsPerUser = 0;
        }

        if(postsCount > 0){
            this.averageCommentsPerPost = (double)  commentsCount / postsCount;
        }
        else  {
            this.averageCommentsPerPost = 0;
        }
    }

    public void showStatistics(){
        System.out.println("Users Count: " + usersCount);
        System.out.println("Posts Count: " + postsCount);
        System.out.println("Comments Count: " + commentsCount);
        System.out.println("Average Posts per User: " + averagePostsPerUser);
        System.out.println("Average Comments per User: " + averageCommentsPerUser);
        System.out.println("Average Comments per Post: " + averageCommentsPerPost);
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
}
