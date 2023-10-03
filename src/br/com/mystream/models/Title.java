package br.com.mystream.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includedInPlan;
    private double sumRating;
    private int totalRatings;
    private int durationInMinutes;

    public Title(String name, int releaseYear, boolean includedInPlan) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.includedInPlan = includedInPlan;
    }

    public Title(OmdbTitle titleOmdb) {
        this.name = titleOmdb.title();
        this.releaseYear = Integer.parseInt(titleOmdb.year());
        this.durationInMinutes =
                Integer.parseInt(titleOmdb.runtime().substring(0, 3).trim());
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean getIncludedInPlan() {
        return includedInPlan;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return String.format("{\"Name\": \"%s\", \"ReleaseYear\": %d, " +
                        "\"Duration\": %d, \"IncludedInPlan\": \"%s\", " +
                        "\"Rate\": %.1f}", getName(), getReleaseYear(),
                getDurationInMinutes(), getIncludedInPlan(), getRateAverage());
    }

    public void rate(double note) {
        sumRating += note;
        totalRatings++;
    }

    public double getRateAverage() {
        if (totalRatings == 0) {
            return 0;
        }
        return sumRating / totalRatings;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }
}
