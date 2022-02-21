public class Main {
    static boolean success = false;

    public static void main(String[] args) {
        int random = (int) (Math.random() * 1000000000);

        Thread timerR = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 0;
                try {
                    while (!success) {
                        System.out.println(x);
                        x++;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        });
        Thread timerR2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!success) {
                    int random2 = (int) (Math.random() * 1000000000);
                    if (random2 == random) {
                        success = true;
                        System.out.println("Число:" + random2);
                    }
                }
            }
        });
        timerR.start();
        timerR2.start();
    }
}


