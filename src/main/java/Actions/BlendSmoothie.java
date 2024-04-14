package Actions;

public class BlendSmoothie implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2500);
            System.out.println("Blending Smoothie...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
