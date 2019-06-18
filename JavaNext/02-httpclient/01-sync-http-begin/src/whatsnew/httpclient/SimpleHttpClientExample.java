package whatsnew.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class SimpleHttpClientExample {

    private static final String GOOGLE_URI = "https://google.com";

    public static void main(String... args) throws Exception {
        var client = HttpClient.newBuilder()
                .followRedirects(Redirect.ALWAYS)
                .build();

        var request = HttpRequest.newBuilder(URI.create(GOOGLE_URI))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            //System.out.println(response.headers().map());
            System.out.println(response.body());
        } else {
            System.out.println(response.statusCode() + ": " + response.body());
        }
    }

}
