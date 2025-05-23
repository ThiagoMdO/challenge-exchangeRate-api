package com.challengeAlura.exchangeRate.runner;

import com.challengeAlura.exchangeRate.modules.CoinPair;
import com.challengeAlura.exchangeRate.modules.SearchRate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Locale;
import java.util.Scanner;

import static com.challengeAlura.exchangeRate.service.RateService.*;
import static com.challengeAlura.exchangeRate.service.SystemService.showMenu;

public class exchangeRateRunner {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        try {
            int option = 1;
            while (option <= 6) {
                System.out.println(showMenu());

                option = scanner.nextInt();

                if (!checkIfOptionIsCorrect(option)) {
                    option = 1;
                    continue;
                }

                System.out.println("Digite o valor que deseja converter:");
                double typedValue = scanner.nextDouble();

                CoinPair coinPair = organizeCoinType(option);

                var response = getPricesFromRateByCurrent(coinPair.currency());

                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                SearchRate searchRate = gson.fromJson(response.body(), SearchRate.class);
                Double rateValue = searchRate.conversion_rates().get(coinPair.rate());

                double converted = typedValue * rateValue;

                System.out.println(showConversion(typedValue, converted, coinPair));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
