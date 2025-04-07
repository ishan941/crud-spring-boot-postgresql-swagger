package com.curdOperation.CurdOperation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LandingController {

    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return "landing";
    }

}
