package br.com.rasmoo.restaurant.service.test;

import br.com.rasmoo.restaurant.dao.ClientDao;
import br.com.rasmoo.restaurant.dao.MenuDao;
import br.com.rasmoo.restaurant.dao.OrderDao;
import br.com.rasmoo.restaurant.entity.Address;
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
        entityManager.getTransaction().begin();

        DataLoadUtil dataLoadUtil = new DataLoadUtil();
        dataLoadUtil.categoryRegister(entityManager);
        dataLoadUtil.productMenuRegister(entityManager);

        MenuDao menuDao = new MenuDao(entityManager);
        ClientDao clientDao = new ClientDao(entityManager);
        OrderDao orderDao = new OrderDao(entityManager);

        Address address = new Address("000000000", "sem teto", "apto 1001", "São Paulo", "SP");

        Client felipe = new Client("11111111111", "Felipe");
        felipe.addAddress(address);

        Order order = new Order(felipe);
        order.addMenuOrders(new MenuOrders(menuDao.idConsult(1), 2));
        order.addMenuOrders(new MenuOrders(menuDao.idConsult(2), 3));

        clientDao.register(felipe);
        orderDao.register(order);

        System.out.println(">> " + order);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}