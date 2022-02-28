package br.com.rasmoo.restaurant.util;

import br.com.rasmoo.restaurant.dao.*;
import br.com.rasmoo.restaurant.entity.*;

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

    public static void clientRegister(EntityManager entityManager)
    {
        ClientDao clientDao = new ClientDao(entityManager);
        AddressDao addressDao = new AddressDao(entityManager);

        Address augusta = new Address("000000000","augusta","casa 43","Sao Paulo","SP");
        Client felipe = new Client("12345678901","felipe@email.com","Felipe Ribeiro");
        felipe.addAddress(augusta);

        Address rioVermelho = new Address("000000001","Rio Vermelho","apto 1001","Salvador","SSA");
        Client cleber = new Client("111111111111","Cleber Machado@email.com","Cleber Machado");
        cleber.addAddress(rioVermelho);

        Address leblon = new Address("000000002","Leblon","apto 203","Rio de Janeiro","RJ");
        Client calvin = new Client("09876543210","Calvin Coelho@email.com","Calvin Coelho");
        calvin.addAddress(leblon);

        Address heitorPenteado = new Address("000000000","Heitor Penteado","apto 101","Sao Paulo","SP");
        Client tayane = new Client("111111111123","tayane@email.com","Tayane Lopes");
        tayane.addAddress(heitorPenteado);

        Address consolacao = new Address("000000000","Consolacao","apto 1001","Sao Paulo","SP");
        Client denise = new Client("111111111145","Denise Costa@email.com","Denise Costa");
        denise.addAddress(consolacao);

        Address nacoesUnidas = new Address("000000000","NacoesUnidas","casa 27","Sao Paulo","SP");
        Client claudia = new Client("111111111345","Claudia Rosa@email.com","Claudia Rosa");
        claudia.addAddress(nacoesUnidas);

        addressDao.register(augusta);
        clientDao.register(felipe);
        addressDao.register(rioVermelho);
        clientDao.register(cleber);
        addressDao.register(leblon);
        clientDao.register(calvin);
        addressDao.register(heitorPenteado);
        clientDao.register(tayane);
        addressDao.register(consolacao);
        clientDao.register(denise);
        addressDao.register(nacoesUnidas);
        clientDao.register(claudia);

        entityManager.flush();
        entityManager.clear();
    }

    public static void registerClientOrders(EntityManager entityManager)
    {
        ClientDao clienteDao = new ClientDao(entityManager);
        MenuDao cardapio = new MenuDao(entityManager);
        OrderDao ordemDao = new OrderDao(entityManager);

        List<Client> clientes = clienteDao.allConsult();
        List<Menu> cardapioList = cardapio.allConsult();

        Order ordemFelipe = new Order(clientes.get(0));
        ordemFelipe.addMenuOrders(new MenuOrders(cardapioList.get(0),2));
        ordemFelipe.addMenuOrders(new MenuOrders(cardapioList.get(5),3));

        Order ordemCleber = new Order(clientes.get(1));
        ordemCleber.addMenuOrders(new MenuOrders(cardapioList.get(0),1));
        ordemCleber.addMenuOrders(new MenuOrders(cardapioList.get(1),2));
        ordemCleber.addMenuOrders(new MenuOrders(cardapioList.get(6),3));

        Order ordemCalvin = new Order(clientes.get(2));
        ordemCalvin.addMenuOrders(new MenuOrders(cardapioList.get(2),2));
        ordemCalvin.addMenuOrders(new MenuOrders(cardapioList.get(9),3));

        Order ordemTayane = new Order(clientes.get(3));
        ordemTayane.addMenuOrders(new MenuOrders(cardapioList.get(0),2));
        ordemTayane.addMenuOrders(new MenuOrders(cardapioList.get(2),3));

        Order ordemDenise = new Order(clientes.get(4));
        ordemDenise.addMenuOrders(new MenuOrders(cardapioList.get(4),2));
        ordemDenise.addMenuOrders(new MenuOrders(cardapioList.get(3),1));

        Order ordemClaudia = new Order(clientes.get(5));
        ordemClaudia.addMenuOrders(new MenuOrders(cardapioList.get(3),2));
        ordemClaudia.addMenuOrders(new MenuOrders(cardapioList.get(5),3));

        ordemDao.register(ordemFelipe);
        ordemDao.register(ordemCleber);
        ordemDao.register(ordemCalvin);
        ordemDao.register(ordemTayane);
        ordemDao.register(ordemDenise);
        ordemDao.register(ordemClaudia);

        entityManager.flush();
        entityManager.clear();
    }
}