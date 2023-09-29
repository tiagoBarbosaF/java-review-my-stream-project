import br.com.mystream.calculations.RecommendationFilter;
import br.com.mystream.calculations.TimeCalculator;
import br.com.mystream.models.Episode;
import br.com.mystream.models.Movie;
import br.com.mystream.models.Series;

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

        Series series = new Series();
        series.setName("Fringe");
        series.setSeasons(4);
        series.setEpisodeForSeason(8);
        series.setMinutesForEpisode(45);
        series.setReleaseYear(2005);
        series.rate(9.9);
        System.out.println(series);
        System.out.println(series.getDurationInMinutes());

        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.includes(movie);
        timeCalculator.includes(series);
        System.out.println(timeCalculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filter(movie);

        Episode episode = new Episode();
        episode.setNumber(1);
        episode.setSeries(series);
        episode.setTotalViews(300);
        filter.filter(episode);
    }
}