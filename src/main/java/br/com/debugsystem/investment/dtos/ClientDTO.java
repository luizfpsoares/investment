package br.com.debugsystem.investment.dtos;

import java.util.List;

public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String cpf;
    private String dateOfBirth;
    private String email;
    private List<Long> accountIds;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String surname, String cpf, String dateOfBirth, String email,
            List<Long> accountIds) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.accountIds = accountIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<Long> accountIds) {
        this.accountIds = accountIds;
    }

    
    
}