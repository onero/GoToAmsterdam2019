package whatsnew.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;


public class AsyncHttpBuilderExample {

    private static final String GOOGLE_URI = "https://google.com";

    public static void main(String... args) {
        var client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        var request = HttpRequest.newBuilder(URI.create(GOOGLE_URI))
                .header("User-Agent", "Java")
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> response =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .whenComplete((res, exception) -> {
                            System.out.println("Version: " + res.version());

                            if (exception != null) {
                                System.out.println("Error  : " + exception);
                            }
                        });

        response.join();
    }
}
