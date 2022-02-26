package br.com.rasmoo.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client
{
    @Id
    private String cpf;
    private String name;
    private String cep;


    public Client() {}

    public Client(String cpf, String name, String cep)
    {
        this.cpf = cpf;
        this.name = name;
        this.cep = cep;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCep()
    {
        return cep;
    }

    public void setCep(String cep)
    {
        this.cep = cep;
    }

    @Override
    public String toString()
    {
        return "Client{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}