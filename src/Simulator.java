import java.util.Map;
import java.util.TreeMap;

public class Simulator {
    private static Simulator ourInstance = new Simulator();
    static final int QUANTITY_CARS = 5;
    static final int QUANTITY_CIRCLE = 4;
    private static Map<Integer, String> result = new TreeMap<>();

    public static Simulator getInstance() {
        return ourInstance;
    }

    private Simulator() {
    }

    public static void main(String[] args) {
        // запускаем потоки
        for (int i = 0; i < QUANTITY_CARS; i++) {
            new Car(QUANTITY_CIRCLE, "Автомобиль " + (i)).start();
        }
        // задержка по времени
        try {
            Thread.sleep(QUANTITY_CIRCLE * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("*** Результат *** ");
        int count = 0;
        for (Map.Entry<Integer, String> entry : result.entrySet()) {
            count++;
            System.out.println(count + " Место: " + entry.getValue() + " Время: " + entry.getKey());
        }
}

    public void addResult(int time, String name) {
        result.put(time, name);
    }
}
