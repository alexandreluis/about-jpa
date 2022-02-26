package service.test;

import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.entity.Menu;
import dao.CategoryDao;
import dao.MenuDao;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class MenuService
{
    public static void main(String[] args)
    {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        productMenuRegister(entityManager, categoryRegister(entityManager));
    }

    public static Category categoryRegister(EntityManager entityManager)
    {
        CategoryDao categoryDao = new CategoryDao(entityManager);
        Category mainDish = new Category("Main Dish");
        entityManager.getTransaction().begin();
        categoryDao.register(mainDish);
        entityManager.getTransaction().commit();
        entityManager.clear();

        return mainDish;
    }

    private static void productMenuRegister(EntityManager entityManager, Category category)
    {
        Menu risoto = new Menu();
        risoto.setName("Risoto de frutos do mar.");
        risoto.setDescription("Risoto acompanhado de lula, polvo e mariscos.");
        risoto.setAvailable(true);
        risoto.setCategory(category);
        risoto.setValue(BigDecimal.valueOf(88.50));

        Menu salmao = new Menu();
        salmao.setName("Salmão ao molho de maracujá");
        salmao.setDescription("Salmão grelhado ao molho de maracujá.");
        salmao.setAvailable(true);
        salmao.setCategory(category);
        salmao.setValue(BigDecimal.valueOf(60.00));


        entityManager.getTransaction().begin();

        MenuDao menuDao = new MenuDao(entityManager);
        menuDao.register(risoto);
        entityManager.flush();
        menuDao.register(salmao);
        entityManager.flush();
        //System.out.println("Dish to consult: " + menuDao.idConsult(1));
        //System.out.println("Dish to consult: " + menuDao.idConsult(2));
        menuDao.allConsult().forEach(element->System.out.println("Dish to consult: " + element));

        entityManager.close();
    }
}