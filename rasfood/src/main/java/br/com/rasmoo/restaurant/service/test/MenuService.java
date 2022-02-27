package br.com.rasmoo.restaurant.service.test;

import br.com.rasmoo.restaurant.dao.MenuDao;
import br.com.rasmoo.restaurant.util.DataLoadUtil;
import br.com.rasmoo.restaurant.util.JPAUtil;

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
        System.out.printf("Produtos pesquisado: " + menuDao.consultPerName("Moqueca").getName());
    }
}