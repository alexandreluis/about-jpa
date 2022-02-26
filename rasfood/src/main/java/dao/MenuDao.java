package dao;

import br.com.rasmoo.restaurant.entity.Menu;
import javax.persistence.EntityManager;
import java.util.List;

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

    public Menu idConsult(final Integer id)
    {
        return this.entityManager.find(Menu.class, id);
    }

    public List<Menu> allConsult()
    {
        String sql = "SELECT m FROM Menu m";
        return this.entityManager.createQuery(sql, Menu.class).getResultList();
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