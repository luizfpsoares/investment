package br.com.debugsystem.investment.dtos;

public class ClientLoginDTO {
    private String cpf;
    private String password;
    
    public ClientLoginDTO() {
    }

    public ClientLoginDTO(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
