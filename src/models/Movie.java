package models;

public class Movie {
    private String name;
    private int releaseYear;
    private boolean includedInPlan;
    private double sumRating;
    private int totalRatings;
    private int durationInMinutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean getIncludedInPlan() {
        return includedInPlan;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
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
        return String.format("Name: %s%n" +
                        "Release Year: %d%n" +
                        "Included in Plan: %s%n" +
                        "Rate: %.2f%n" +
                        "Duration in Minutes: %d%n", name, releaseYear,
                includedInPlan, getRateAverage(), durationInMinutes);
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
