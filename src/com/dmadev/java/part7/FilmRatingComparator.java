package com.dmadev.java.part7;

import java.util.Comparator;

public class FilmRatingComparator implements Comparator<Film> {
    @Override
    public int compare(Film f1, Film f2) {
        return Float.compare(f1.rating, f2.rating);
    }
}
