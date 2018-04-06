package jh.thread.executor;

/**
 * 测试线程当前处于的状态
 *
 * Created by 17020751 on 2018/4/6.
 */
public class ThreadStatusTest {

    public static void main(String[] args) {
        Thread.currentThread().setName("jh-main-thread");
        ThreadStatusTest tt = new ThreadStatusTest();
        tt.testBlocked();
    }

    public void testNew(){
        Thread thread = new Thread();
        System.out.println(thread.getState()); // NEW
    }

    public void testRUNNABLE(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < Integer.MAX_VALUE; i ++) {
                    System.out.println(i);
                }
            }
        }, "RUNNABLE-Thread");
        thread.start();
    }

    public void testBlocked(){
        final Object lock = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " invoke");
                    try {
                        Thread.sleep(201000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "BLOCKED-Thread-A");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " invoke");
                    try {
                        Thread.sleep(20000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "BLOCKED-Thread-B");
        threadA.start();
        threadB.start();
    }
}
