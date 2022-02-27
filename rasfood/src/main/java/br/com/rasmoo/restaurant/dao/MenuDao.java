package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Menu;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
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

    public Menu consultPerName(final String filtro)
    {
        try
        {
            String jpql = "SELECT m FROM Menu m WHERE UPPER(m.name) = UPPER(:name)";
            return this.entityManager.createQuery(jpql, Menu.class).setParameter("name", filtro).getSingleResult();
        }catch(Exception ex)
        {
            return null;
        }
    }

    public List<Menu> consultPerValue(final BigDecimal filtro)
    {
        try
        {
            String jpql = "SELECT m FROM Menu m WHERE m.value = :value";
            return this.entityManager.createQuery(jpql, Menu.class).setParameter("value", filtro).getResultList();
        }catch(Exception ex)
        {
            return Collections.emptyList();
        }
    }

    public List<Menu> allConsult()
    {
        try
        {
            String jpql = "SELECT m FROM Menu m";
            return this.entityManager.createQuery(jpql, Menu.class).getResultList();
        }catch(Exception ex)
        {
            return Collections.emptyList();
        }
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