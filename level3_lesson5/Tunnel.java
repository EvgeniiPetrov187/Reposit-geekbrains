package level3_lesson5;

import java.util.concurrent.Semaphore;

import static level3_lesson5.Main.CARS_COUNT;

public class Tunnel extends Stage {
    //В туннель не может заехать одновременно больше половины участников (условность).
    Semaphore tunnel = new Semaphore(CARS_COUNT/2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                tunnel.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                tunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
