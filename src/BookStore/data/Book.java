package BookStore.data;

import java.io.Serializable;

public abstract class Book implements Serializable {
    private Long id;
    private String name;
    private int price;
    private int count;
    private int sold;
    public abstract String showDetails();

    public Book() {}

    public Book(Long id, String name, int price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Book(Long id, String name, int price, int count, int sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.sold = sold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
