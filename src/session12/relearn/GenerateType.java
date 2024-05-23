package session12.relearn;



import java.util.HashMap;
import java.util.Map;

public class GenerateType<K,V,N> {
private K key;
private V value;
private N value1;




    @Override
    public String toString() {
        return "GenerateType{" +
                "key=" + key +
                ", value=" + value +
                ", value1=" + value1 +
                '}';
    }

    public GenerateType() {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public N getValue1() {
        return value1;
    }

    public void setValue1(N value1) {
        this.value1 = value1;
    }
}
