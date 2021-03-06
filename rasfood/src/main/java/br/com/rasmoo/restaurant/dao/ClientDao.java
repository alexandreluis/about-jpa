package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.entity.Client;
import br.com.rasmoo.restaurant.entity.ClientId;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao
{
    private EntityManager entityManager;


    public ClientDao() {}

    public ClientDao(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void register(final Client client)
    {
        this.entityManager.persist(client);
    }

    public Client idConsult(final ClientId id)
    {
        return this.entityManager.find(Client.class, id);
    }

    public List<Client> allConsult()
    {
        String jpql = "SELECT c FROM Client c";
        return this.entityManager.createQuery(jpql, Client.class).getResultList();
    }

    public List<Client> consultPerName(final String name)
    {
        String jpql = "SELECT c FROM Client c WHERE LOWER(c.name) LIKE LOWER(:name)";
        return this.entityManager.createQuery(jpql, Client.class).setParameter("name", "%" + name + "%").getResultList();
    }

    public void update(final Client client)
    {
        this.entityManager.merge(client);
    }

    public void delete(final Client client)
    {
        this.entityManager.remove(client);
    }
}