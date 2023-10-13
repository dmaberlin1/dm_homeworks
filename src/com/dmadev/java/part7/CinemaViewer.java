package com.dmadev.java.part7;

import java.util.Vector;

public class CinemaViewer {
    protected Cinema cinema;
    
    public CinemaViewer() {
        cinema = new Cinema();
    }
    
    public void runTests() {
        cinema.addFilm(new Film(1, 1983, 2, "Fantasy", 0.87f));
        cinema.addFilm(new Film(1, 1, 5, "Nothing", 0.88f));
        cinema.addFilm(new Film(1, 1234, 0, "Horror", 0.5f));
        
        System.out.println(cinema.getFilmById(1).genre); // Fantasy
        System.out.println(cinema.getFilms("Horror").size()); // 0
        
        cinema.addFilm(new Film(2, 2012, 7, "Comedy", 0.82f));
        cinema.addFilm(new Film(3, 2018, 1, "Comedy", 0.65f));
        cinema.addFilm(new Film(4, 2077, 11, "Fantasy", 0.9f));
        cinema.addFilm(new Film(5, 2000, 2, "Western", 0.75f));
        cinema.addFilm(new Film(6, 2011, 2, "Drama", 0.63f));
        
        Vector<Film> all = cinema.getFilms();
        for (Film f: all) {
            System.out.println(String.format("id: %d | year: %d | month: %d | genre: %s | rating: %d%%", f.id, f.releaseYear, f.releaseMonth, f.genre, (int)(f.rating * 100)));
        }
    }
}
