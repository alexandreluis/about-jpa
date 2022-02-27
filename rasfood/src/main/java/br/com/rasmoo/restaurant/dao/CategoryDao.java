package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao
{
    private EntityManager entityManager;


    public CategoryDao() {}

    public CategoryDao(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void register(final Category category)
    {
        this.entityManager.persist(category);
    }

    public Category idConsult(final Integer id)
    {
        return this.entityManager.find(Category.class, id);
    }

    public List<Category> allConsult()
    {
        String jpql = "SELECT c FROM Category c";
        return this.entityManager.createQuery(jpql, Category.class).getResultList();
    }

    public void update(final Category category)
    {
        this.entityManager.merge(category);
    }

    public void delete(final Category category)
    {
        this.entityManager.remove(category);
    }
}