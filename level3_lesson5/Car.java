package level3_lesson5;

import static level3_lesson5.Main.finish;
import static level3_lesson5.Main.ready;
import static level3_lesson5.Main.start;

public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private boolean firstPlace = true;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            //Все участники должны стартовать одновременно, несмотря на то,
            // что на подготовку у каждого из них уходит разное время.
            start.countDown();
            ready.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        //Только после того как все завершат гонку, нужно выдать объявление об окончании.
        System.out.println(this.name + " Финиш");
        finish.countDown();
    }
}