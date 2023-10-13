package com.dmadev.java.part7;

public class Film {
    public int id;
    public int releaseYear;
    public int releaseMonth;
    public String genre;
    public float rating;
    
    public Film() {}
    public Film(int id, int year, int month, String genre, float rating) {
        this.id = id;
        releaseYear = year;
        releaseMonth = month;
        this.genre = genre;
        this.rating = rating;
    }
}
