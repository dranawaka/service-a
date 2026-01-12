package com.aurelius.tech.servicea.controller;


import com.aurelius.tech.servicea.Repository.UserRepository;
import com.aurelius.tech.servicea.model.ServiceAResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/1.0")
public class ServiceARestController {


    UserRepository userRepository;

    ServiceARestController(UserRepository userRepository){

        this.userRepository = userRepository;
    }


    @GetMapping("/hello")
    ServiceAResponse hello(){

        ServiceAResponse serviceAResponse = new ServiceAResponse();

        serviceAResponse.setMessage(userRepository.findAll().get(0).getName());

        return serviceAResponse;
    }

}
