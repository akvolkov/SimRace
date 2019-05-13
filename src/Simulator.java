import java.util.Map;
import java.util.TreeMap;

public class Simulator {
    private static Simulator ourInstance = new Simulator();
    static final int QUANTITY_CARS = 10;
    static final int QUANTITY_CIRCLE = 10;

    public Map<Integer, String> getResult() {
        return result;
    }

    private static Map<Integer, String> result = new TreeMap<>();

    public static Simulator getInstance() {
        return ourInstance;
    }

    private Simulator() {
    }

    public static void main(String[] args) {
        // запускаем потоки авто
        for (int i = 0; i < QUANTITY_CARS; i++) {
            new Car(QUANTITY_CIRCLE, "Автомобиль " + (i)).start();
        }
        // запускаем поток аварии
        new Accident().start();
}

    public void addResult(int time, String name) {
        result.put(time, name);
    }
}
