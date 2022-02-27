package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_value")
    private BigDecimal totalValue = BigDecimal.ZERO;

    @Column(name = "criationDate")
    private LocalDateTime dateOfCreation = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    /*
     * ALL = Realiza todas as operações em cascata
     * DETACH = Operacao detach executada no pai e no filho
     * MERGE = Salva pai e filho, podende já haver a entidade gerenciada
     * PERSIST = Cria pai e filho
     * REFRESH = Atualiza entidade com operacoes do banco
     * REMOVE = Propaga remocao entre pai e filho
     * */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<MenuOrders> menuOrdersList = new ArrayList<>();

    public Order() {}

    public Order(Client client)
    {
        this.client = client;
    }

    public void addMenuOrders(MenuOrders menuOrders)
    {
        menuOrders.setOrder(this);
        this.menuOrdersList.add(menuOrders);
        this.totalValue = totalValue.add(menuOrders.getRecordValue().multiply(BigDecimal.valueOf(menuOrders.getAmount())));
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public BigDecimal getTotalValue()
    {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue)
    {
        this.totalValue = totalValue;
    }

    public LocalDateTime getDateOfCreation()
    {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation)
    {
        this.dateOfCreation = dateOfCreation;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public List<MenuOrders> getMenuOrdersList()
    {
        return menuOrdersList;
    }

    public void setMenuOrdersList(List<MenuOrders> menuOrdersList)
    {
        this.menuOrdersList = menuOrdersList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalValue=" + totalValue +
                ", dateOfCreation=" + dateOfCreation +
                ", client=" + client +
                ", menuOrdersList=" + menuOrdersList +
                '}';
    }
}