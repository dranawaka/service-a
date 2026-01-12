package com.aurelius.tech.servicea.controller;


import com.aurelius.tech.servicea.Repository.UserRepository;
import com.aurelius.tech.servicea.model.ServiceAResponse;
import com.aurelius.tech.servicea.model.ServiceBResponse;
import com.aurelius.tech.servicea.service.ServiceAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/1.0")
public class ServiceARestController {


    UserRepository userRepository;

    ServiceAService serviceAService;

    ServiceARestController(UserRepository userRepository, ServiceAService serviceAService){
        this.userRepository = userRepository;
        this.serviceAService = serviceAService;
    }



    @GetMapping("/hello")
    ServiceAResponse hello(){

        ServiceAResponse serviceAResponse = new ServiceAResponse();

        serviceAResponse.setMessage(userRepository.findAll().get(0).getName());

        return serviceAResponse;
    }

    @GetMapping("/service-b")
    ServiceBResponse getResponse(){

        return serviceAService.callService();

    }


}
