import br.com.mystream.exceptions.MyPersonalException;
import br.com.mystream.models.OmdbTitle;
import br.com.mystream.models.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String search = "";
        List<Title> listTitles = new ArrayList<>();


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try {
            FileWriter writer = new FileWriter("movies.json", true);
            while (!search.equalsIgnoreCase("exit")) {
                System.out.print("Search title: ");
                search = scanner.nextLine();

                String url = String.format("%s%s%s", "http://www.omdbapi.com/?t=",
                        search.trim().replace(" ", "+"), "&apikey=a9399783");
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                if (search.equalsIgnoreCase("exit")) {
                    break;
                }

                try {
                    HttpResponse<String> response = client.send(request,
                            HttpResponse.BodyHandlers.ofString());

                    String json = response.body();

                    System.out.println(json);

                    OmdbTitle titleOmdb = gson.fromJson(json, OmdbTitle.class);

                    Title title = new Title(titleOmdb);

                    listTitles.add(title);

                } catch (IOException | InterruptedException |
                         NumberFormatException |
                         MyPersonalException e) {
                    System.out.print("Error: " + e.getMessage());
                }
            }
            writer.write(gson.toJson(listTitles));
            writer.close();
            System.out.println("\nProgram finished!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}