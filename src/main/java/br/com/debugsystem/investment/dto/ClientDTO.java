package br.com.debugsystem.investment.dto;

import java.util.List;

import br.com.debugsystem.investment.entities.Account;
import br.com.debugsystem.investment.entities.Client;

public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String cpf;
    private String dateOfBirth;
    private String email;
    //private List<Account> accounts;

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        surname = client.getSurname();
        cpf = client.getCpf();
        dateOfBirth = client.getDateOfBirth();
        email = client.getEmail();
        //accounts = Account.getClient()
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    
}
