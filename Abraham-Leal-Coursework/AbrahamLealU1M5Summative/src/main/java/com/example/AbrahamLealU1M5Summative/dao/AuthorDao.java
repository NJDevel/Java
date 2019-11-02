package com.example.AbrahamLealU1M5Summative.dao;

import com.example.AbrahamLealU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {

    //Your DAO API must allow callers to create, read, read all, update, and delete Books, Authors, and
    // Publishers in the system. The system must also allow callers to find Books by Author.

    Author addAuthor(Author author);

    Author getAuthor(int id);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(int id);

}
