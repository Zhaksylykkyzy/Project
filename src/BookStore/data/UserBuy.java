package BookStore.data;



import java.io.Serializable;

public class UserBuy implements Serializable {  //Потому что,  мы будем его в сети будем передавать
    private Long id; // чтобы можно было задавать на id null
    private Long user_id; // чтобы можно было задавать на id null
    private String genre;
    private int count;
    private int totalsum;

    public UserBuy() {}
    public UserBuy(Long id, Long user_id, String genre, int count, int totalsum) {
        this.id = id;
        this.user_id = user_id;
        this.genre = genre;
        this.count = count;
        this.totalsum = totalsum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(int totalsum) {
        this.totalsum = totalsum;
    }
}

