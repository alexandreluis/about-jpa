package service.test;

import br.com.rasmoo.restaurant.entity.Menu;
import dao.MenuDao;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class MenuService
{
    public static void main(String[] args)
    {
        Menu risoto = new Menu();
        risoto.setName("Risoto de frutos do mar.");
        risoto.setDescription("Risoto acompanhado de lula, polvo e mariscos.");
        risoto.setAvailable(true);
        risoto.setValue(BigDecimal.valueOf(88.50));

        Menu salmao = new Menu();
        risoto.setName("Salmão ao molho de maracujá");
        risoto.setDescription("Salmão grelhado ao molho de maracujá.");
        risoto.setAvailable(true);
        risoto.setValue(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        MenuDao menuDao = new MenuDao(entityManager);
        menuDao.register(risoto);
        entityManager.flush();
        menuDao.register(salmao);
        entityManager.flush();
        System.out.println("Dish to consult: " + menuDao.consult(1));

        menuDao.delete(salmao);
        System.out.println("Dish to consult: " + menuDao.consult(2));

        entityManager.clear();
        risoto.setValue(BigDecimal.valueOf(75.80));
        menuDao.update(risoto);
        System.out.println("Dish to consult: " + menuDao.consult(1));
    }
}