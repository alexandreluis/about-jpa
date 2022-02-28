package br.com.rasmoo.restaurant.dao;


import br.com.rasmoo.restaurant.entity.Address;
import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.valueObject.ClientVO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        String jpql = "SELECT new br.com.rasmoo.restaurant.valueObject.ClientVO(a.client.clientId.cpf, a.client.name) FROM Address a " +
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

    public List<ClientVO> ClientConsultUsingCriteria(final String state, final String city, final String street)
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClientVO> criteriaQuery = builder.createQuery(ClientVO.class);
        Root<Address> root = criteriaQuery.from(Address.class);
        criteriaQuery.multiselect(root.get("client").get("clientId").get("cpf"), root.get("client").get("name"));
        Predicate predicate = builder.and();

        if(Objects.nonNull(state))
        {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("state")), state.toUpperCase()));
        }

        if(Objects.nonNull(city))
        {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("city")), city.toUpperCase()));
        }

        if(Objects.nonNull(street))
        {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("street")), street.toUpperCase()));
        }

        criteriaQuery.where(predicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
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