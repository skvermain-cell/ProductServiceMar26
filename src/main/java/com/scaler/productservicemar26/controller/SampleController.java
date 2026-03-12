package com.scaler.productservicemar26.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController - hosts REST APIs
@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,
                           @PathVariable("times") int times) {

        String s = "";
        for (int i=1; i<=times; i++) {
            s += "Hello from Scaler, " + name + "! <BR/>";
        }

        return s;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi Scaler!";
    }
}
