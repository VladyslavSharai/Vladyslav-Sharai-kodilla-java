package com.kodilla.testing.library;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;
    private BookLibrary bookLibrary;

    private List<Book> generateListOfNBooks(int booksQuantity){
        List<Book> resultList = new ArrayList<>();
        for(int i = 0; i < booksQuantity; i++){
            Book book = new Book("Title" + i, "Author" + i, 1970 + i);
            resultList.add(book);
        }
        return resultList;
    }

    @BeforeEach
    void setUp() {
        bookLibrary = new BookLibrary(libraryDatabaseMock);
    }

    @Test
    void testListBooksWithConditionsReturnList() {
        List<Book> resultListOfBooks  = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        assertEquals(4, theListOfBooks.size());

    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        List<Book> resultListOfBooks  = new ArrayList<>();
        List<Book> resultList15fBooks = generateListOfNBooks(15);
        List<Book> resultList40fBooks = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultList15fBooks);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOfBooks);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultList40fBooks);

        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {

        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testListBooksInHandsOf0Books(){
        LibraryUser libraryUser = new LibraryUser("Vladyslav", "Sharai", "8747474747");
        List<Book> theListOfBooks = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(theListOfBooks);

        List<Book> ResultTheListOfBooks = bookLibrary.listBooksInHandsOf(libraryUser);

        assertEquals(0, ResultTheListOfBooks.size());

    }

    @Test
    void testListBooksInHandsOf1Books(){
        LibraryUser libraryUser = new LibraryUser("Vladyslav", "Sharai", "8747474747");
        List<Book> theListOf1Book = new ArrayList<>();
        Book book1 = new Book("Title1", "Author1", 1970 + 1);
        theListOf1Book.add(book1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(theListOf1Book);

        List<Book> ResultTheListOfBooks = bookLibrary.listBooksInHandsOf(libraryUser);

        assertEquals(1, ResultTheListOfBooks.size());
        assertEquals(book1, ResultTheListOfBooks.get(0));
    }

    @Test
    void testListBooksInHandsOf5Books(){
        LibraryUser libraryUser = new LibraryUser("Vlad", "Sharai", "8747474747");
        List<Book> theListOf5Books = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(theListOf5Books);

        List<Book> ResultTheListOf5Books = bookLibrary.listBooksInHandsOf(libraryUser);

        assertEquals(5, ResultTheListOf5Books.size());
    }

    @Test
    void testListBooksInHandsOfShouldCallDatabaseWithCorrectUser(){
        LibraryUser user = new LibraryUser("Vlad", "Sharai", "8747474747");
        List <Book> expectedBooks = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(user)).thenReturn(expectedBooks);

        List<Book> resultList = bookLibrary.listBooksInHandsOf(user);

        Assertions.assertEquals(expectedBooks, resultList);
        Assertions.assertEquals(expectedBooks.size(), resultList.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(user);

    }
}