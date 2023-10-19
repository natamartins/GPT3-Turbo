package com.convertion;

import static spark.Spark.*;
// import com.convertion.api.GPT3Service;

public class Main {

    public static void main(String[] args) {
        port(8080);

        post("/receber-dados", (request, response) -> {
            String dadosRecebidos = request.body();
            // String testGpt = GPT3Service.getGptResponse("Onde fica o Brasil?");

            // System.out.println("GPT3 Turbo ===> : " + testGpt);
            System.out.println("Dados recebidos: " + dadosRecebidos);

            response.status(200);
            return "Dados recebidos com sucesso! ";
        });
    }
}
