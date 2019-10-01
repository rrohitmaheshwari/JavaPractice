package threadExamples;

public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println("Another Thread");

        try{
            Thread.sleep(3000);

        }
        catch (InterruptedException e){
            System.out.println("Another thread woke me up");
            return;
        }
        System.out.println("3 sec have passed");
    }
}
