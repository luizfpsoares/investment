package br.com.debugsystem.investment.dtos;

public class ActiveDTO {
    private Long id;
    private String name;
    private String code;
    private String accountType;

    public ActiveDTO() {
    }

    public ActiveDTO(Long id, String name, String code, String accountType) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.accountType = accountType;
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
}
