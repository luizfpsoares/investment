package br.com.debugsystem.investment.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.dtos.ClientDTO;
import br.com.debugsystem.investment.entities.Client;
import br.com.debugsystem.investment.infra.ClientRepository;

@Service
public class LoginService {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    public ClientDTO findByCpfAndSenha(String cpf, String password) {
        Client clientLogado = clientRepository.findByCpf(cpf);
        if (clientLogado == null) {
            logger.info("CPF don't find on database");
            return null;
        }

        if (password.equals(clientLogado.getPassword())) {
            logger.info("Client autenticated with success...", clientLogado.getCpf());
            return clientService.convertToDTO(clientLogado);
        } else {
            logger.info("Incorrect password", clientLogado.getCpf());
            return null;
        }
    }
}
