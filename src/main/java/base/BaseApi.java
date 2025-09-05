package base;

import java.net.http.HttpClient;

public class BaseApi {
    protected final HttpClient httpClient;

    public BaseApi() {
        this.httpClient = HttpClient.newHttpClient();
    }
}
