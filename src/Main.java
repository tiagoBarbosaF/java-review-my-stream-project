import br.com.mystream.models.OmdbTitle;
import br.com.mystream.models.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search title: ");
        String search = scanner.nextLine();

        String url = String.format("%s%s%s", "http://www.omdbapi.com/?t=",
                search.trim().replace(" ", "+"), "&apikey=a9399783");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        Gson gson =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);
            OmdbTitle titleOmdb = gson.fromJson(json, OmdbTitle.class);
            System.out.println(titleOmdb);

            Title title = new Title(titleOmdb);

            System.out.println(title);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}