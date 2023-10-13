package com.dmadev.java.part7;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

public class Cinema {
    protected SortedMap<Integer, Vector<Film>> storage;
    
    public Cinema() {
        storage = new TreeMap<Integer,Vector<Film>>();
    }
    
    public void addFilm(Film f) {
        if (getFilmById(f.id) != null)
            return;
        
        Vector<Film> reference = storage.get(f.releaseYear);
        if (reference == null) {
            reference = new Vector<Film>();
            storage.put(f.releaseYear, reference);
        }
        
        reference.addElement(f);
    }
    
    public Vector<Film> getFilms(int releaseYear) {
        return storage.get(releaseYear);
    }
    public Vector<Film> getFilms(int year, int month) {
        Vector<Film> raw = new Vector<Film>(getFilms(year));
        raw.removeIf(f -> f.releaseMonth != month);
        return raw;
    }
    public Vector<Film> getFilms(String genre) {
        Vector<Film> output = new Vector<Film>();
        for (Vector<Film> yearCollection: storage.values()) {
            for (Film f: yearCollection) {
                if (f.genre == genre)
                    output.addElement(f);
            }
        }
        return output;            
    }
    public Vector<Film> getFilms() {
        Vector<Film> output = new Vector<Film>();
        for (Vector<Film> yearCollection: storage.values()) {
            for (Film f: yearCollection) {
                output.addElement(f);
            }
        }
        return output;            
    }
    public Film getFilmById(int id) {
        Vector<Film> raw = getFilms();
        for (Film f: raw) {
            if (f.id == id )
                return f;
        }
        return null;
    }
    
    public Vector<Film> getMostRated(int top) {
        Vector<Film> films = getFilms();
        films.sort(new FilmRatingComparator());
        if (films.size() > top)
            films.setSize(top);
        return films;
    }
}
