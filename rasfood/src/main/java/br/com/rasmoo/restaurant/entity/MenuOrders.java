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

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    @Column(name = "value_record")
    private BigDecimal recordValue;

    private Integer amount;

    public MenuOrders(Menu menu, Integer amount)
    {
        this.menu = menu;
        this.amount = amount;
        this.recordValue = menu.getValue();
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

    public BigDecimal getRecordValue()
    {
        return recordValue;
    }

    public void setRecordValue(BigDecimal recordValue)
    {
        this.recordValue = recordValue;
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
                ", menu=" + menu +
                ", recordValue=" + recordValue +
                ", amount=" + amount +
                '}';
    }
}