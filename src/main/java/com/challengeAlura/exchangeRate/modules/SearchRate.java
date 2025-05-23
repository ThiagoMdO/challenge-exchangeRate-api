package com.challengeAlura.exchangeRate.modules;

import java.util.Map;

public record SearchRate(
        String base_code,
        Map<String, Double> conversion_rates
) {
}
