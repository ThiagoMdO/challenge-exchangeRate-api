package com.challengeAlura.exchangeRate.service;

import com.challengeAlura.exchangeRate.modules.CoinPair;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RateService {
    
    public static boolean checkIfOptionIsCorrect(Integer option) {
        if (option < 1 || option > 7) {
            System.out.println("Opção invalida, tente novamente");
            return false;
        }  
        return true;
    }

    public static CoinPair organizeCoinType(int option) {
        return switch (option) {
            case 1 -> new CoinPair("USD", "ARS");
            case 2 -> new CoinPair("ARS", "USD");
            case 3 -> new CoinPair("USD", "BRL");
            case 4 -> new CoinPair("BRL", "USD");
            case 5 -> new CoinPair("USD", "COP");
            case 6 -> new CoinPair("COP", "USD");
            default -> new CoinPair("USD", "BRL");
        };
    }

    public static HttpResponse<String> getPricesFromRateByCurrent(String currency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/642f9706f68a19a8efd19db1/latest/" + currency))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static String showConversion(double typedValue, double converted, CoinPair coinPair) {
        return "O valor de " + typedValue + " [" + coinPair.currency() + "]"
                + " corresponde ao valor de =>>> " + converted + " [" + coinPair.rate() + "]";
    }
}
