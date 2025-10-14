public class MyThreads {

    // Nested Thread class
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread is running...");
        }
    }
    static class newThread implements Runnable{
        @Override
        public void run() {
            System.out.println("NewThread is running...");
        }
    }

    public static void main(String[] args) {
        //MyThread thread = new MyThread();
        Thread thread = new Thread(()-> System.out.println("Java8Thread..."));
        thread.start();
        Runnable task = ()->{
            System.out.println("Java8NewThread is running...");
        };
        newThread t2 = new newThread();
        Thread t = new Thread(task);
        t.start();
    }
}
