package com.kodilla.testing.forum.statistics;


import com.kodilla.testing.library.Book;
import com.kodilla.testing.library.LibraryDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestForumStatistics {
    @Mock
    private Statistics statisticsMock;

    private ForumStatistics forumStatistics;

    @BeforeEach
    public void setUp() {
        forumStatistics = new ForumStatistics();
    }

    private List<String> generateListOfUsers(int count){
        List<String> listOfUsers = new ArrayList<>();
        for(int i = 0; i < count; i++){
            listOfUsers.add("User" + i);
        }
        return listOfUsers;
    }

    @Test
    void testForumStatistics0Post(){
        List<String> mockUsers = new ArrayList<>();
        mockUsers.add("User1");
        mockUsers.add("User2");
        when(statisticsMock.usersNames()).thenReturn(mockUsers);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(3);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2, forumStatistics.getUsersCount());
        assertEquals(0, forumStatistics.getPostsCount());
        assertEquals(3, forumStatistics.getCommentsCount());
        assertEquals(0, forumStatistics.getAveragePostsPerUser());
        assertEquals(1.5, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testForumStatistics1000Post(){
        List<String> mockUsers = new ArrayList<>();
        mockUsers.add("User1");
        mockUsers.add("User2");
        when(statisticsMock.usersNames()).thenReturn(mockUsers);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(5);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2, forumStatistics.getUsersCount());
        assertEquals(1000, forumStatistics.getPostsCount());
        assertEquals(5, forumStatistics.getCommentsCount());
        assertEquals(500.0, forumStatistics.getAveragePostsPerUser());
        assertEquals(2.5, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.005, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testForumStatistics0Comment(){
        List<String> mockUsers = new ArrayList<>();
        mockUsers.add("User1");
        mockUsers.add("User2");
        when(statisticsMock.usersNames()).thenReturn(mockUsers);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(0);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2, forumStatistics.getUsersCount());
        assertEquals(5, forumStatistics.getPostsCount());
        assertEquals(0, forumStatistics.getCommentsCount());
        assertEquals(2.5, forumStatistics.getAveragePostsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testForumStatisticsCommentLessPosts(){
        List<String> mockUsers = new ArrayList<>();
        mockUsers.add("User1");
        mockUsers.add("User2");
        when(statisticsMock.usersNames()).thenReturn(mockUsers);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(5);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2, forumStatistics.getUsersCount());
        assertEquals(10, forumStatistics.getPostsCount());
        assertEquals(5, forumStatistics.getCommentsCount());
        assertEquals(5, forumStatistics.getAveragePostsPerUser());
        assertEquals(2.5, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testForumStatisticsCommentsMorePosts(){
        List<String> mockUsers = new ArrayList<>();
        mockUsers.add("User1");
        mockUsers.add("User2");
        when(statisticsMock.usersNames()).thenReturn(mockUsers);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(10);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2, forumStatistics.getUsersCount());
        assertEquals(5, forumStatistics.getPostsCount());
        assertEquals(10, forumStatistics.getCommentsCount());
        assertEquals(2.5, forumStatistics.getAveragePostsPerUser());
        assertEquals(5, forumStatistics.getAverageCommentsPerUser());
        assertEquals(2, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testForumStatistics0Users(){
        List<String> mockUsers = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(mockUsers);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(5);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getUsersCount());
        assertEquals(5, forumStatistics.getPostsCount());
        assertEquals(5, forumStatistics.getCommentsCount());
        assertEquals(0, forumStatistics.getAveragePostsPerUser());
        assertEquals(0, forumStatistics.getAverageCommentsPerUser());
        assertEquals(1, forumStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testForumStatistics100Users(){
        List<String> mockUsers = generateListOfUsers(100);
        when(statisticsMock.usersNames()).thenReturn(mockUsers);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(5);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(100, forumStatistics.getUsersCount());
        assertEquals(10, forumStatistics.getPostsCount());
        assertEquals(5, forumStatistics.getCommentsCount());
        assertEquals(0.1, forumStatistics.getAveragePostsPerUser());
        assertEquals(0.05, forumStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, forumStatistics.getAverageCommentsPerPost());
    }
}
