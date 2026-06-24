package com.example.apigateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGWController {

    @GetMapping("/test")
    public String test(){
        return "Gateway Funcionando";
    }


}
