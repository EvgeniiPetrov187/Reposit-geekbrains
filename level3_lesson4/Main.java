package level3_lesson4;

public class Main {
    private static final Object object = new Object();
    private static volatile char letter = 'A';

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (object) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != 'A')
                            object.wait();
                        System.out.print('A');
                        letter = 'B';
                        object.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (object) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != 'B')
                            object.wait();
                        System.out.print('B');
                        letter = 'C';
                        object.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (object) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (letter != 'C')
                            object.wait();
                        System.out.print('C');
                        letter = 'A';
                        object.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
