package br.com.rasmoo.restaurant.dao;


import br.com.rasmoo.restaurant.entity.Address;
import br.com.rasmoo.restaurant.entity.Category;

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

    public void update(final Address address)
    {
        this.entityManager.merge(address);
    }

    public void delete(final Address address)
    {
        this.entityManager.remove(address);
    }
}