package br.com.mystream.models;

public class Series extends Title {
    private int seasons;
    private boolean active;
    private int episodesForSeason;
    private int minutesForEpisode;

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
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

    public void setEpisodeForSeason(int episodesForSeason) {
        this.episodesForSeason = episodesForSeason;
    }

    public int getMinutesForEpisode() {
        return minutesForEpisode;
    }

    public void setMinutesForEpisode(int minutesForEpisode) {
        this.minutesForEpisode = minutesForEpisode;
    }

    @Override
    public int getDurationInMinutes() {
        return (seasons * episodesForSeason) * minutesForEpisode;
    }
}
