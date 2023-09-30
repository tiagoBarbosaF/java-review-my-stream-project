import br.com.mystream.calculations.RecommendationFilter;
import br.com.mystream.calculations.TimeCalculator;
import br.com.mystream.models.Episode;
import br.com.mystream.models.Movie;
import br.com.mystream.models.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("Castlevania", 2023, true, 100, "Bob Bob");
        movie.rate(7.5);
        movie.rate(6.3);
        movie.rate(9.2);
        movie.rate(8.1);

        System.out.println(movie);
        System.out.println(movie.getTotalRatings());
        System.out.printf("%.2f%n", movie.getRateAverage());

        Series series = new Series("Fringe", 2005, false, 4, 8);
        series.rate(9.9);
        System.out.println(series);
        System.out.println(series.getDurationInMinutes());

        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.includes(movie);
        timeCalculator.includes(series);
        System.out.println(timeCalculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(movie);

        Episode episode = new Episode("The Begin", 1, series, 45);
        for (int i = 0; i < 2500; i++) {
            episode.playEpisode();
        }
        filter.filter(episode);

        series.addEpisode(episode);
        System.out.println("Total minutes series: " + series.getTotalMinutesForSeason());
        System.out.println(series);

        Movie movie2 = new Movie("One Piece Z", 2010, true, 100, "Eichiro Oda");
        movie2.rate(9);
        movie2.rate(9.5);
        movie2.rate(10);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        movieList.add(movie2);
        System.out.println(movieList);
    }
}