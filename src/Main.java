import models.Movie;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setName("Castlevania");
        movie.setReleaseYear(2023);
        movie.setDurationInMinutes(100);


        movie.rate(7.5);
        movie.rate(6.3);
        movie.rate(9.2);
        movie.rate(8.1);

        System.out.println(movie);
        System.out.println(movie.getTotalRatings());
        System.out.printf("%.2f%n", movie.getRateAverage());
    }
}