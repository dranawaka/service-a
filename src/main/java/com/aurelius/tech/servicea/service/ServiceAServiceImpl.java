package com.aurelius.tech.servicea.service;

import com.aurelius.tech.servicea.model.ServiceBResponse;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class ServiceAServiceImpl implements ServiceAService{


    @Autowired
    private  WebClient webClient;

    @Override
    @CircuitBreaker(name = "serviceB", fallbackMethod = "fallback")
    @Retry(name = "serviceB")
    public ServiceBResponse callService() {

        String response =  webClient.get()
                .uri("http://service-b:8080/1.0/service-b")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(response);


        ServiceBResponse serviceBResponse =  new ServiceBResponse();
        serviceBResponse.setMessage(response);

        return serviceBResponse;

    }

    // fallback method
    public ServiceBResponse fallback(Throwable ex) {

        ServiceBResponse serviceBResponse =  new ServiceBResponse();
        serviceBResponse.setMessage("Fallback response (Service B unavailable)");

        return serviceBResponse;
    }

}
