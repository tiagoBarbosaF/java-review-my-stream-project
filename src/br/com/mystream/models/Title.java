package br.com.mystream.models;

public class Title {
    private String name;
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
                        "\"IncludedInPlan\": \"%s\", \"Rate\": %.1f}",
                getName(), getReleaseYear(),
                getIncludedInPlan(), getRateAverage());
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
}
