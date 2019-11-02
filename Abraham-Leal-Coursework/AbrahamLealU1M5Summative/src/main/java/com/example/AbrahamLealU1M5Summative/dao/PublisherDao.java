package com.example.AbrahamLealU1M5Summative.dao;

import com.example.AbrahamLealU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {

    //Your DAO API must allow callers to create, read, read all, update, and delete Books, Authors, and
    // Publishers in the system. The system must also allow callers to find Books by Author.

    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);
}
