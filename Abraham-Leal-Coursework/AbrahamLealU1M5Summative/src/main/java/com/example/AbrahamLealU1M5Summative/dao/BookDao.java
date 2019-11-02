package com.example.AbrahamLealU1M5Summative.dao;

import com.example.AbrahamLealU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {

    //Your DAO API must allow callers to create, read, read all, update, and delete Books, Authors, and
    // Publishers in the system. The system must also allow callers to find Books by Author.

    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBook(int id);

    List<Book> getBooksByAuthor(int authorId);

}
