package br.com.debugsystem.investment.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.debugsystem.investment.dtos.ClientDTO;
import br.com.debugsystem.investment.dtos.ClientLoginDTO;
import br.com.debugsystem.investment.services.LoginService;
import br.com.debugsystem.investment.config.ErrorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/v1/login")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody ClientLoginDTO clientLogin) {
        ClientDTO client = loginService.findByCpfAndSenha(clientLogin.getCpf(), clientLogin.getPassword());
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("CPF ou senha inválidos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
    
}
