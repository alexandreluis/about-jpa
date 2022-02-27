package br.com.rasmoo.restaurant.util;

import br.com.rasmoo.restaurant.entity.Category;
import br.com.rasmoo.restaurant.entity.Menu;
import br.com.rasmoo.restaurant.dao.CategoryDao;
import br.com.rasmoo.restaurant.dao.MenuDao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class DataLoadUtil
{
    public DataLoadUtil(){}

    public static void categoryRegister(EntityManager entityManager)
    {
        Category appetizer = new Category("Appetizer");
        Category salad = new Category("Salad");
        Category mainDish = new Category("MainDish");

        CategoryDao categoryDao = new CategoryDao(entityManager);

        categoryDao.register(appetizer);
        entityManager.flush();
        categoryDao.register(salad);
        entityManager.flush();
        categoryDao.register(mainDish);
        entityManager.flush();
        entityManager.clear();
    }

    public static void productMenuRegister(EntityManager entityManager)
    {
        CategoryDao categoryDao = new CategoryDao(entityManager);
        MenuDao menuDao = new MenuDao(entityManager);

        List<Category> categorias = categoryDao.allConsult();
        Menu moqueca = new Menu("Moqueca", "Peixe branco, banana da terra, arroz e farofa",
                true, BigDecimal.valueOf(95.00), categorias.get(2));
        Menu spaguetti = new Menu("Spaguetti", "Spagatti ao molho de parmesão e cogumelos",
                true, BigDecimal.valueOf(68.00), categorias.get(2));
        Menu bife = new Menu("Bife", "Bife acebolado com arroz branco, farofa e batata frita",
                true, BigDecimal.valueOf(59.00), categorias.get(2));
        Menu cordeiro = new Menu("Cordeiro", "Cordeiro com risoto de funghi",
                true, BigDecimal.valueOf(88.00), categorias.get(2));
        Menu burrata = new Menu("Burrata", "Tomates queimados, rúcula e torrada",
                true, BigDecimal.valueOf(15.00), categorias.get(0));
        Menu bruschetta = new Menu("Bruschetta", "Tomate, mucarela e manjericao",
                true, BigDecimal.valueOf(20.00), categorias.get(0));
        Menu scappeta = new Menu("Scappeta", "Ragu de linguica e torradinhas",
                true, BigDecimal.valueOf(25.00), categorias.get(0));
        Menu caprese = new Menu("Caprese", "Mini rucula e mucarela",
                true, BigDecimal.valueOf(47.00), categorias.get(1));
        Menu caesar = new Menu("Caesar", "Salada de franco com molho ceasar",
                true, BigDecimal.valueOf(40.00), categorias.get(1));
        Menu chevre = new Menu("Chevre", "Mix de folhas, mostarda e mel",
                true, BigDecimal.valueOf(59.00), categorias.get(1));

        menuDao.register(moqueca);
        menuDao.register(spaguetti);
        menuDao.register(bife);
        menuDao.register(cordeiro);
        menuDao.register(burrata);
        menuDao.register(bruschetta);
        menuDao.register(scappeta);
        menuDao.register(caprese);
        menuDao.register(caesar);
        menuDao.register(chevre);
        entityManager.flush();
        entityManager.clear();
    }
}