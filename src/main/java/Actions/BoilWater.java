package Actions;

public class BoilWater implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Boiling water...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
