package br.com.debugsystem.investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.dtos.ClientDTO;
import br.com.debugsystem.investment.entities.Client;
import br.com.debugsystem.investment.infra.ClientRepository;

@Service
public class LoginService {
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    public ClientDTO findByCpfAndSenha(String cpf, String password) {
        Client clientLogado = clientRepository.findByCpf(cpf);
        if(password == clientLogado.getPassword()) {
            return clientService.convertToDTO(clientLogado);
        } else {
            return null;
        }
    }
}
