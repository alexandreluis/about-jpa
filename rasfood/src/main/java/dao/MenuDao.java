package dao;

import br.com.rasmoo.restaurant.entity.Menu;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
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


    public MenuDao(){}

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

    public List<Menu> consultPerValue(final BigDecimal filtro)
    {
        String jpql = "SELECT m FROM Menu m WHERE m.value = :value";
        return this.entityManager.createQuery(jpql, Menu.class).setParameter("value", filtro).getResultList();
    }

    public List<Menu> allConsult()
    {
        String jpql = "SELECT m FROM Menu m";
        return this.entityManager.createQuery(jpql, Menu.class).getResultList();
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