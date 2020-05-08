package BookStore.data;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String login;
    private String password;
    private String imya;
    private int role;

    public User() {}

    public User(Long id, String login, String password, String imya, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.imya = imya;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
