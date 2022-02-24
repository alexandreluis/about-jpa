package dao;

import br.com.rasmoo.restaurant.entity.Dish;
import javax.persistence.EntityManager;

/*
C = CREATE
R = READ
U = UPDATE
D = DELETE
 */
public class DishDao
{
    private EntityManager entityManager;

    public DishDao(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void register(final Dish dish)
    {
        this.entityManager.persist(dish);
        System.out.println("Entity save: " + dish);
    }

    public Dish consult(final Integer id)
    {
        return this.entityManager.find(Dish.class, id);
    }

    public void update(final Dish dish)
    {
        this.entityManager.merge(dish);
    }

    public void delete(final Dish dish)
    {
        this.entityManager.remove(dish);
    }
}