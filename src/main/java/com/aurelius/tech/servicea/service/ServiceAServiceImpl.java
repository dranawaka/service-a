package com.aurelius.tech.servicea.service;

import com.aurelius.tech.servicea.model.ServiceBResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class ServiceAServiceImpl implements ServiceAService{


    @Autowired
    private  WebClient webClient;

    @Override
    public ServiceBResponse callService() {

        String response =  webClient.get()
                .uri("http://localhost:8082/1.0/service-b")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ServiceBResponse serviceBResponse =  new ServiceBResponse();
        serviceBResponse.setMessage(response);

        return serviceBResponse;

    }
}
