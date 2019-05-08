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
        System.out.println("Старт! " + name);
        int ms = 0;
        for (int i = 0; i < count; i++) {
            ms = (int) (Math.random() * 100);
            time += ms;
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " проехал круг №" + (i + 1) + " за " + ms + " ms");
        }
        System.out.println("Финиш! " + name);
        System.out.println(name + " проехал весь маршрут за " + time + " ms");
        Simulator.getInstance().addResult(time, name);
    }
}
