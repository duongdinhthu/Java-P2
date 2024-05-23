package sessionGenerateType.entity;

public class Entity<T> {
    private T id;// T la cac kieu du lieu khac nhau ,du lieu nao cung duoc

    public T getId() {
        return id;
    }

    public Entity(T id) {
        this.id = id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
