package dao;

import br.com.rasmoo.restaurant.entity.Menu;
import javax.persistence.EntityManager;

/*
C = CREATE
R = READ
U = UPDATE
D = DELETE
 */
public class MenuDao
{
    private EntityManager entityManager;

    public MenuDao(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void register(final Menu menu)
    {
        this.entityManager.persist(menu);
    }

    public Menu consult(final Integer id)
    {
        return this.entityManager.find(Menu.class, id);
    }

    public void update(final Menu menu)
    {
        this.entityManager.merge(menu);
    }

    public void delete(final Menu menu)
    {
        this.entityManager.remove(menu);
    }
}