package br.com.rasmoo.restaurant.dao;


import br.com.rasmoo.restaurant.entity.Address;
import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.valueObject.ClientVO;

import javax.persistence.EntityManager;
import java.util.List;

public class AddressDao
{
    private EntityManager entityManager;

    public AddressDao(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void register(final Address address)
    {
        this.entityManager.persist(address);
    }

    public Category consultPerId(final Integer id)
    {
        return this.entityManager.find(Category.class, id);
    }

    public List<Address> allConsult()
    {
        String jpql = "SELECT a FROM Address a";
        return this.entityManager.createQuery(jpql, Address.class).getResultList();
    }

    public List<ClientVO> ClientConsult(final String state, final String city, final String street)
    {
        String jpql = "SELECT new br.com.rasmoo.restaurant.valueObject.ClientVO(a.client.cpf, a.client.name) FROM Address a " +
                "WHERE UPPER(a.state) = UPPER(:state) AND " +
                "UPPER(a.city) = UPPER(:city) AND " +
                "UPPER(a.street) = UPPER(:street)";
        return this.entityManager.createQuery(jpql, ClientVO.class).setParameter("state", state).setParameter("city", city).setParameter("street", street).getResultList();
    }

    public void update(final Address address)
    {
        this.entityManager.merge(address);
    }

    public void delete(final Address address)
    {
        this.entityManager.remove(address);
    }
}