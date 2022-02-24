package service.test;

import br.com.rasmoo.restaurant.entity.Dish;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rasFood");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(risoto);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}