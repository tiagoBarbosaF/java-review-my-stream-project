package br.com.mystream.models;

import br.com.mystream.calculations.Sortable;

public class Movie extends Title implements Sortable {
    private String director;

    public Movie(String name, int releaseYear, boolean includedInPlan,
                 int durationInMinutes, String director) {
        super(name, releaseYear, includedInPlan);
        this.setDurationInMinutes(durationInMinutes);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public int getClassification() {
        return (int) (getRateAverage() / 2);
    }
}
