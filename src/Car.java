public class Car extends Thread {
    int count;
    String name;
    int time = 0;

    public Car(int count, String name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public void run() {
        int ms = 0;
        for (int i = 0; i < count; i++) {
            ms = (int) (Math.random() * 100);
            System.out.println(name + " круг = " + i + "ms = " + ms);
            time += ms;
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("time = " + time);
        Simulator.getInstance().addResult(time, name);
    }
}
