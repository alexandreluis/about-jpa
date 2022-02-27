package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Client;
import br.com.rasmoo.restaurant.entity.Order;
import br.com.rasmoo.restaurant.valueObject.MainItemsVO;

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

    public List<MainItemsVO> seeBestSellingItems()
    {
        String jpql = "SELECT new br.com.rasmoo.restaurant.valueObject.MainItemsVO(c.name, SUM(oc.amount)) FROM Order o " +
                "JOIN MenuOrders oc ON o.id = oc.menu.id " +
                "JOIN oc.menu c " +
                "GROUP BY c.name " +
                "ORDER BY SUM(oc.amount) DESC";
        return this.entityManager.createQuery(jpql, MainItemsVO.class).getResultList();
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