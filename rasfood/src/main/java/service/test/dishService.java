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

        Dish salmao = new Dish();
        risoto.setName("Salmão ao molho de maracujá");
        risoto.setDescription("Salmão grelhado ao molho de maracujá.");
        risoto.setAvailable(true);
        risoto.setValue(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        DishDao dishDao = new DishDao(entityManager);
        dishDao.register(risoto);
        entityManager.flush();
        dishDao.register(salmao);
        entityManager.flush();
        System.out.println("Dish to consult: " + dishDao.consult(1));

        dishDao.delete(salmao);
        System.out.println("Dish to consult: " + dishDao.consult(2));

        entityManager.clear();
        risoto.setValue(BigDecimal.valueOf(75.80));
        dishDao.update(risoto);
        System.out.println("Dish to consult: " + dishDao.consult(1));
    }
}