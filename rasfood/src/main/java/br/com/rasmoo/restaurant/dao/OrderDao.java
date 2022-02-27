package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Client;
import br.com.rasmoo.restaurant.entity.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDao
{
    private EntityManager entityManager;


    public OrderDao() {}

    public OrderDao(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void register(final Order order)
    {
        this.entityManager.persist(order);
    }

    public Order idConsult(final Integer id)
    {
        return this.entityManager.find(Order.class, id);
    }

    public List<Order> allConsult()
    {
        String jpql = "SELECT o FROM Order o";
        return this.entityManager.createQuery(jpql, Order.class).getResultList();
    }

    public void update(final Order order)
    {
        this.entityManager.merge(order);
    }

    public void delete(final Order order)
    {
        this.entityManager.remove(order);
    }
}