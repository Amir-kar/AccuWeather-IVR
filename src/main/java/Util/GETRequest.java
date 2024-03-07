package Util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GETRequest {
    private String URL;
    GETRequest(String URL){
        this.URL=URL;
    }
    public static String sendRequest(String URL) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}