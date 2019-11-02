package com.example.U1M4SummativeLealAbraham.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteCatalog {
    protected List<Quote> quotes = new ArrayList<>();
    Random random = new Random();

    public QuoteCatalog() {

    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Quote getRandomQuote() {


        return quotes.get(random.nextInt(quotes.size()));
    }
}
