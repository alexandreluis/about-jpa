package br.com.rasmoo.restaurant.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "menu")
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private boolean available;
    private BigDecimal value;

    @ManyToOne
    private Category category;

    @Column(name = "Registration_date")
    private LocalDateTime RegistrationDate = LocalDateTime.now();

    public Menu(String name, String description, boolean available, BigDecimal value, Category category) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.value = value;
        this.category = category;
    }

    public Menu(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        RegistrationDate = registrationDate;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", value=" + value +
                ", category=" + category +
                ", RegistrationDate=" + RegistrationDate +
                '}';
    }
}