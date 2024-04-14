package Actions;

public class MakeToast implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Making toast...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
