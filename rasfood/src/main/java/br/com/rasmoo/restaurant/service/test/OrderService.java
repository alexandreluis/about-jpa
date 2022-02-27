package br.com.rasmoo.restaurant.service.test;

import br.com.rasmoo.restaurant.dao.ClientDao;
import br.com.rasmoo.restaurant.dao.MenuDao;
import br.com.rasmoo.restaurant.dao.OrderDao;
import br.com.rasmoo.restaurant.entity.Client;
import br.com.rasmoo.restaurant.entity.MenuOrders;
import br.com.rasmoo.restaurant.entity.Order;
import br.com.rasmoo.restaurant.util.DataLoadUtil;
import br.com.rasmoo.restaurant.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


public class OrderService
{
    public static void main(String[] args)
    {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        DataLoadUtil dataLoadUtil = new DataLoadUtil();
        entityManager.getTransaction().begin();
        dataLoadUtil.categoryRegister(entityManager);
        dataLoadUtil.productMenuRegister(entityManager);

        MenuDao menuDao = new MenuDao(entityManager);
        ClientDao clientDao = new ClientDao(entityManager);
        OrderDao orderDao = new OrderDao(entityManager);

        Client felipe = new Client("11111111111", "Felipe", "000000000");
        Order order = new Order(felipe);
        order.addMenuOrders(new MenuOrders(order, menuDao.idConsult(1), 2));
        clientDao.register(felipe);
        orderDao.register(order);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}