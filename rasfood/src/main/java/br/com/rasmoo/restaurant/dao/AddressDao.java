package br.com.rasmoo.restaurant.dao;


import br.com.rasmoo.restaurant.entity.Address;
import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.valueObject.ClientVO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

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
                "WHERE 1 = 1";

        if(Objects.nonNull(state))
        {
            jpql = jpql.concat(" AND UPPER(a.state) = UPPER(:state) ");
        }

        if(Objects.nonNull(city))
        {
            jpql = jpql.concat(" AND UPPER(a.city) = UPPER(:city) ");
        }

        if(Objects.nonNull(street))
        {
            jpql = jpql.concat(" AND UPPER(a.street) = UPPER(:street)");
        }


        TypedQuery typedQuery = this.entityManager.createQuery(jpql, ClientVO.class);

        if(Objects.nonNull(state))
        {
            typedQuery.setParameter("state", state);
        }

        if(Objects.nonNull(city))
        {
            typedQuery.setParameter("city", city);
        }

        if(Objects.nonNull(street))
        {
            typedQuery.setParameter("street", street);
        }

        return typedQuery.getResultList();
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