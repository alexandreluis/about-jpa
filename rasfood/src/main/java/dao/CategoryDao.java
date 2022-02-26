package dao;

import br.com.rasmoo.restaurant.entity.Category;

import javax.persistence.EntityManager;

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

    public Category read(final Integer id)
    {
        return this.entityManager.find(Category.class, id);
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