package Actions;

public class BrewCoffee implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2500);
            System.out.println("Brewing coffee...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
