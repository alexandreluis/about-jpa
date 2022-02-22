package br.com.rasmoo.restaurant.entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "pratos")
public class Prato
{
    private Integer id;
    private String name;
    private String description;
    private boolean available;
    private BigDecimal value;
    private LocalDateTime RegistrationDate = LocalDateTime.now();

    public prato(){}

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

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", value=" + value +
                ", RegistrationDate=" + RegistrationDate +
                '}';
    }
}