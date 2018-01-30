package jh.thread.lock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by 17020751 on 2017/11/28.
 */
public class Synchronizer implements Lock {

    @Test
    public void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Synchronizer s = new Synchronizer();
                s.lock();
                System.out.println("------" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("------1111" + Thread.currentThread().getName());
                s.unlock();
            }
        };
        executorService.submit(r);
        executorService.execute(r);
        executorService.execute(r);
        executorService.execute(r);
        executorService.execute(r);
        executorService.execute(r);
        executorService.execute(r);
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    //自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {

    }

    private final Sync sync = new Sync();
}
