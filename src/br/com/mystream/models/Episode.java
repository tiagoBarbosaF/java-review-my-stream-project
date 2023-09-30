package br.com.mystream.models;

import br.com.mystream.calculations.Sortable;

public class Episode implements Sortable {
    private String name;
    private int number;
    private Series series;
    private final int minutesForEpisodes;
    private static int totalViews;

    public Episode(String name, int number, Series series, int minutesForEpisodes) {
        this.name = name;
        this.number = number;
        this.series = series;
        this.minutesForEpisodes = minutesForEpisodes;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Series getSeries() {
        return series;
    }

    public int getMinutesForEpisodes() {
        return minutesForEpisodes;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void playEpisode() {
        totalViews++;
    }

    @Override
    public int getClassification() {
        if (totalViews > 100) {
            return 4;
        }
        return 2;
    }
}
