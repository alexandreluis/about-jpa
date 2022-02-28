package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client
{
    @EmbeddedId
    private ClientId clientId;

    private String name;

    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    public Client() {}

    public Client(String cpf, String email, String name)
    {
        this.clientId = new  ClientId(cpf, email);
        this.name = name;
    }

    public void addAddress(Address address)
    {
        address.setClient(this);
        this.addressList.add(address);
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getCpf()
    {
        return clientId.getCpf();
    }

    public void setCpf(String cpf)
    {
        this.clientId.setCpf(cpf);
    }

    public String getEmail()
    {
        return clientId.getEmail();
    }

    public void setEmail(String Email)
    {
        this.clientId.setEmail(Email);
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
                "cpf='" + clientId.getCpf() + '\'' +
                "cpf='" + clientId.getEmail() + '\'' +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", addressList=" + addressList +
                '}';
    }
}