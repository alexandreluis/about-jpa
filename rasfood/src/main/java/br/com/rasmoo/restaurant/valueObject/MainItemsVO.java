package br.com.rasmoo.restaurant.valueObject;

public class MainItemsVO
{
    private String name;
    private Long amount;


    public MainItemsVO() {}

    public MainItemsVO(String name, Long amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "MainItemsVO{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}