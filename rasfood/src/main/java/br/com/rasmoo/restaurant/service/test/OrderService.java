package br.com.rasmoo.restaurant.service.test;

import br.com.rasmoo.restaurant.dao.AddressDao;
import br.com.rasmoo.restaurant.dao.ClientDao;
import br.com.rasmoo.restaurant.dao.MenuDao;
import br.com.rasmoo.restaurant.dao.OrderDao;
import br.com.rasmoo.restaurant.entity.*;
import br.com.rasmoo.restaurant.util.DataLoadUtil;
import br.com.rasmoo.restaurant.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class OrderService
{
    public static void main(String[] args)
    {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();

        DataLoadUtil dataLoadUtil = new DataLoadUtil();
        dataLoadUtil.categoryRegister(entityManager);
        dataLoadUtil.productMenuRegister(entityManager);
        dataLoadUtil.clientRegister(entityManager);
        dataLoadUtil.registerClientOrders(entityManager);

        AddressDao addressDao = new AddressDao(entityManager);

        ClientDao clientDao = new ClientDao(entityManager);
        System.out.println(clientDao.idConsult(new ClientId("felipe@email.com", "12345678901")));
        entityManager.close();
    }
}