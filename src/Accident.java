import java.util.Map;

public class Accident extends Thread {
    static int range = Simulator.QUANTITY_CIRCLE * 50;//500
    static int crashTime = Simulator.QUANTITY_CIRCLE * 50 + (int) (Math.random() * range);

    @Override
    public void run() {
        try {
            Thread.sleep(crashTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<Integer, String> result = Simulator.getInstance().getResult();
        if (result.size() == Simulator.QUANTITY_CARS) {
            System.out.println("*** Результат *** ");
            int count = 0;
            for (Map.Entry<Integer, String> entry : result.entrySet()) {
                count++;
                System.out.println(count + " Место: " + entry.getValue() + " Время: " + entry.getKey());
            }
        } else {
            System.out.println("Произошла авария на " + crashTime + "ms");
        }
    }
}
