import br.com.mystream.models.Movie;
import br.com.mystream.models.Series;
import br.com.mystream.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("Castlevania", 2023, true, 100, "Bob Bob");
        movie.rate(7.5);

        Series series = new Series("Fringe", 2005, false, 4, 8);
        series.rate(9.9);

        Movie movie2 = new Movie("One Piece Z", 2010, true, 100, "Eichiro Oda");
        movie2.rate(9);

        ArrayList<Title> list = new ArrayList<>();
        list.add(movie);
        list.add(movie2);
        list.add(series);

        System.out.println("\nUsing foreach");
        for (Title title :
                list) {
            System.out.println(title.getName());
        }

        System.out.println("\nUsing lambda foreach");
        List<Movie> movies = list.stream()
                .filter(title -> title instanceof Movie)
                .map(title -> (Movie) title)
                .toList();
        movies.forEach(item -> System.out.println(item.getClassification()));

//        Collections.sort(list);
        list.forEach(item -> System.out.println(item.getName()));
        list.sort(Title::compareTo);
        System.out.println(list);
        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println(list);


        System.out.println("\nPracticing with lists:");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Pineapple");
        fruits.add("Strawberry");
        fruits.add("Pearl");
        fruits.add("Apple");
        fruits.add("Kiwi");
        fruits.add("Grape");
        fruits.add("Orange");
        System.out.println(fruits);

        fruits.sort(String::compareTo);
        System.out.println(fruits);
    }
}