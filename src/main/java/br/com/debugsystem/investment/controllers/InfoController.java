package br.com.debugsystem.investment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/info")
public class InfoController {

    @GetMapping
    public String apiVersion() {
        return "<h1>version: 0.0.1</h1>";
    }
    
}
