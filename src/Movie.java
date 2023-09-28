public class Movie {
    String name;
    int releaseYear;
    boolean includedInPlan;
    double sumRating;
    int totalRatings;
    int durationInMinutes;

    @Override
    public String toString() {
        return String.format("Name: %s%n" +
                        "Release Year: %d%n" +
                        "Included in Plan: %s%n" +
                        "Rate: %.2f%n" +
                        "Duration in Minutes: %d%n", name, releaseYear,
                includedInPlan, getRateAverage(), durationInMinutes);
    }

    void rate(double note) {
        sumRating += note;
        totalRatings++;
    }

    double getRateAverage() {
        if (totalRatings == 0) {
            return 0;
        }
        return sumRating / totalRatings;
    }
}
