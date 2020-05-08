package BookStore.data;

import java.io.Serializable;

public class Plus extends Book implements Serializable {
    private String country;
    private int year;
    private String genre;

    public Plus() {
    }
    public Plus(Long id, String name, int price, int count, String country, int year, String genre) {
        super(id, name, price, count);
        this.country = country;
        this.year = year;
        this.genre = genre;
    }

    public Plus(Long id, String name, int price, int count, int sold, String country, int year, String genre) {
        super(id, name, price, count, sold);
        this.country = country;
        this.year = year;
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String showDetails(){
        return getCountry()+" "+ getYear();
    }
}
