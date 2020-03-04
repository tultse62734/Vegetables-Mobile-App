package fptu.sumer.foodstore_api.model;

import java.io.Serializable;

public class Category implements Serializable {

    private int id;
    private String name;

    public Category() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
