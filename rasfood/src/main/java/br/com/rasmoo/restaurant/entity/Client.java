package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client
{
    @Id
    private String cpf;
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public Client() {}

    public Client(String cpf, String name)
    {
        this.cpf = cpf;
        this.name = name;
    }

    public void addAddress(Address address)
    {
        address.setClient(this);
        this.addressList.add(address);
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

    public List<Address> getAddressList()
    {
        return addressList;
    }

    public void setAddressList(List<Address> addressList)
    {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", addressList=" + addressList +
                '}';
    }
}