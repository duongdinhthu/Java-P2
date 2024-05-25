package baithi.entity;


public class Entity <T>{
    private T idok;

    public Entity(T id) {
        this.idok = id;
    }

    public Entity() {
    }

    public T getId() {
        return idok;
    }

    public void setId(T id) {
        this.idok = id;
    }
}
