package Actions;

public class BoilEgg implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1500);
            System.out.println("Boiling eggs...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
