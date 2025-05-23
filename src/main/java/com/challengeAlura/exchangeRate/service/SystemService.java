package com.challengeAlura.exchangeRate.service;

public class SystemService {

    public static String showMenu() {
        return """
                ******************************************************
                
                Seja bem vindo/a ao Conversor de Moeda:");
                1) Dolár =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileiro
                4) Real brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Sair
                
                ******************************************************
                """;
    }
}
