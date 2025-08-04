package rudy.currencyconverter.service;

import com.google.gson.Gson;
import rudy.currencyconverter.model.ExchangeResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {

    private static final String API_KEY = "6d156c3690d9a454facea6db";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client;
    private final Gson gson;

    public CurrencyConverter() {
        client = HttpClient.newHttpClient();
        gson = new Gson();
    }

    public ExchangeResponse obtenerTasas(String base) {
        try {
            String url = BASE_URL + API_KEY + "/latest/" + base;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), ExchangeResponse.class);

        } catch (Exception e) {
            System.out.println("❌ Error al obtener datos: " + e.getMessage());
            return null;
        }
    }
}
