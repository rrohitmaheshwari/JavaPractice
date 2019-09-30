package threadExamples;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();
        // anotherThread.start(); can only run once

        //for anonymous class we need to start immediately

        new Thread() {
            @Override
            public void run() {
                System.out.println("Anonymous Thread");
            }
        }.start();



        new Thread(()->{System.out.println("Anonymous Thread Lambda");}).start();

        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        Thread myRunnableA = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Runnable");
            }
        });
        myRunnableA.start();

        System.out.println("Hello Again from main thread"); //order may or may not be maintained for all

    }
}
