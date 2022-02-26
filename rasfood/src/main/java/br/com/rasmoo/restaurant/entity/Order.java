package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "criationDate")
    private LocalDateTime dateOfCreation = LocalDateTime.now();

    @ManyToOne
    private Client cliente;

    @ManyToMany
    @JoinTable(
            name = "orders_menu",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> menuList;

    public Order() {}

    public Order(Client cliente)
    {
        this.cliente = cliente;
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

    public Client getCliente()
    {
        return cliente;
    }

    public void setCliente(Client cliente)
    {
        this.cliente = cliente;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "id=" + id +
                ", totalValue=" + totalValue +
                ", dateOfCreation=" + dateOfCreation +
                ", cliente=" + cliente +
                '}';
    }
}