package MutableString;

public class MutableStringTest {

    private MutableString ms = new MutableString("");

    public void addProperty(String name, String value) {
        if (value != null && value.length() > 0) {
            if (ms.length() > 0) {
                ms.append(",");
            }
            ms.append(name).append("=").append(value);
        }
    }

    public static void main(String[] args) {

        MutableString test = new MutableString("test");

        Thread A = new Thread(() -> test.append("Annamaria"));
        // Thread A = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // test.append("A");
        // }
        // });
        Thread B = new Thread(() -> test.append("Bela"));
        Thread C = new Thread(() -> test.append("Cesar"));
        A.start();
        B.start();
        C.start();
        try {
            A.join();
            B.join();
            C.join();
        } catch (InterruptedException e) {
        }
        System.out.println(test);
    }
}
