package threadExamples;

public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println("Another Thread");
    }
}
