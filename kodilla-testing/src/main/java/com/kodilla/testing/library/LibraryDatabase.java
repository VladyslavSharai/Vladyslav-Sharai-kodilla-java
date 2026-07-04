package com.kodilla.testing.library;

import java.util.*;

public interface LibraryDatabase {
    List<Book> listBooksWithCondition(String title);
    List<Book> listBooksInHandsOf(LibraryUser libraryUser);
    boolean rentABook(LibraryUser libraryUser, Book book);
    int returnBooks(LibraryUser libraryUser);
}
