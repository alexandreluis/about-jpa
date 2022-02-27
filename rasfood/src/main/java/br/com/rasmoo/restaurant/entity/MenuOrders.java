package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders_menu")
public class MenuOrders
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Menu menu;

    private BigDecimal value;

    private Integer amount;

    public MenuOrders(Order order, Menu menu, Integer amount)
    {
        this.order = order;
        this.menu = menu;
        this.amount = amount;
    }

    public MenuOrders(){}

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

    public BigDecimal getValue()
    {
        return value;
    }

    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "MenuOrders{" +
                "id=" + id +
                ", order=" + order +
                ", menu=" + menu +
                ", value=" + value +
                ", amount=" + amount +
                '}';
    }
}