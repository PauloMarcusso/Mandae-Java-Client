package com.mandae;

import com.mandae.api.ClientApiException;
import com.mandae.api.RestauranteClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ListagemRestaurantesMain {

    public static void main(String[] args) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://localhost:8080");

            restauranteClient.listar().forEach(restaurante -> System.out.println(restaurante));

        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem().getUserMessage());
            } else {
                System.out.println("Erro Desconhecido");
            }
        }
    }

}
