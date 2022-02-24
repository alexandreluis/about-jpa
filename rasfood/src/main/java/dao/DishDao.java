package dao;

import br.com.rasmoo.restaurant.entity.Dish;

import javax.persistence.EntityManager;

public class DishDao
{
    private EntityManager entityManager;

    public DishDao(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void save(Dish dish)
    {
        this.entityManager.persist(dish);
        System.out.println("Entity save: " + dish);
    }
}