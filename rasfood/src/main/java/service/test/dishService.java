package service.test;

import br.com.rasmoo.restaurant.entity.Dish;
import dao.DishDao;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class dishService
{
    public static void main(String[] args)
    {
        Dish risoto = new Dish();
        risoto.setName("Risoto de frutos do mar.");
        risoto.setDescription("Risoto acompanhado de lula, polvo e mariscos.");
        risoto.setAvailable(true);
        risoto.setValue(BigDecimal.valueOf(88.50));

        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        DishDao dishDao = new DishDao(entityManager);
        dishDao.register(risoto);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}