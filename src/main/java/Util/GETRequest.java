package Util;

import org.json.JSONException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GETRequest {
    private String URL;
    GETRequest(String URL){
        this.URL=URL;
    }
    public static String sendRequest(String URL) throws IOException, InterruptedException, JSONException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}