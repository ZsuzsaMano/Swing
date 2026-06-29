package Draw;

public class SimpleModel {
    private int value;

    public int getValue() {
        return value;
    }

    public void incr() {
        value++;
        System.out.println(value);
    }
}