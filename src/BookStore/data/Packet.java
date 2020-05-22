package BookStore.data;

import java.io.Serializable;

public class Packet implements Serializable {
    private String code; // для  сервера нужно: add,list,login,registration
    private Serializable data; /*Все что мы отправляем по сети-serializible,  /(*****Интерфейс, полиморфизм использовали*****)
                                поэтому можно использовать такой способ,
                                в эту data можем добавить хоть что, если он serializible*/

    public Packet() {}
    public Packet(String code, Serializable data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }
}
