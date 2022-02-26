package service.test;

import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.entity.Menu;
import dao.CategoryDao;
import dao.MenuDao;
import util.DataLoadUtil;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class MenuService
{
    public static void main(String[] args)
    {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        DataLoadUtil dataLoadUtil = new DataLoadUtil();
        entityManager.getTransaction().begin();
        dataLoadUtil.categoryRegister(entityManager);
        dataLoadUtil.productMenuRegister(entityManager);
        MenuDao menuDao = new MenuDao(entityManager);
        System.out.printf("Lista de produtos por valor: " + menuDao.consultPerValue(BigDecimal.valueOf(59.00)));
    }
}