package br.com.mystream.models;

import br.com.mystream.calculations.Sortable;

public class Movie extends Title implements Sortable {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) (getRateAverage() / 2);
    }
}
