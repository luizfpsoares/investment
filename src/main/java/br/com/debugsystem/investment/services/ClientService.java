package br.com.debugsystem.investment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.entities.Client;
import br.com.debugsystem.investment.infra.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void updateCLient(Client client, Long id) {
        Client exist = clientRepository.findById(id).orElseThrow();
        exist.setName(client.getName());
        exist.setSurname(client.getSurname());
        exist.setEmail(client.getEmail());
        clientRepository.save(exist);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

}
