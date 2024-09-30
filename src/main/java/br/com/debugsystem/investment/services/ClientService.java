package br.com.debugsystem.investment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.debugsystem.investment.dtos.ClientDTO;
import br.com.debugsystem.investment.entities.Client;
import br.com.debugsystem.investment.infra.ClientRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO getById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + id));
        return convertToDTO(client);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void updateCLient(Client client, Long id) {
        Client exist = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + id));
        exist.setName(client.getName());
        exist.setSurname(client.getSurname());
        exist.setEmail(client.getEmail());
        clientRepository.save(exist);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    private ClientDTO convertToDTO(Client client) {
        List<Long> accountIds = client.getAccounts().stream()
            .map(account -> account.getId())
            .collect(Collectors.toList());

        return new ClientDTO(
            client.getId(),
            client.getName(),
            client.getSurname(),
            client.getCpf(),
            client.getDateOfBirth(),
            client.getEmail(),
            accountIds
        );
    }

}
