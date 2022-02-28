package br.com.rasmoo.restaurant.valueObject;

public class ClientVO
{
    private String cpf;
    private String name;

    public ClientVO() {}

    public ClientVO(String cpf, String name)
    {
        this.cpf = cpf;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientVO{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}