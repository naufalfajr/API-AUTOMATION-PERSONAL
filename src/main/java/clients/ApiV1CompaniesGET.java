package clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import base.BaseApi;

public class ApiV1CompaniesGET extends BaseApi {
    private static final String BASE_URL = "https://fakerapi.it/api/v1/companies?_quantity=%d";

    public String callApiV1CompaniesGET(int qty) throws IOException, InterruptedException {
        String url = String.format(BASE_URL, qty);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Request failed: HTTP "+response.statusCode()+" - "+response.body());
        }

        return response.body();
    }
}
