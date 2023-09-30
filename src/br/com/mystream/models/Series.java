package br.com.mystream.models;

import java.util.ArrayList;

public class Series extends Title {
    private int seasons;
    private boolean active;
    private int episodesForSeason;
    private int totalMinutesForSeason;
    private ArrayList<Episode> episodes;

    public Series(String name, int releaseYear, boolean includedInPlan, int seasons, int episodesForSeason) {
        super(name, releaseYear, includedInPlan);
        this.seasons = seasons;
        this.episodesForSeason = episodesForSeason;
        this.episodes = new ArrayList<>();
    }

    public int getSeasons() {
        return seasons;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodesForSeason() {
        return episodesForSeason;
    }

    public int getTotalMinutesForSeason() {
        totalMinutesForSeason = this.episodes
                .stream()
                .mapToInt(Episode::getMinutesForEpisodes)
                .sum();
        return totalMinutesForSeason;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }
}
