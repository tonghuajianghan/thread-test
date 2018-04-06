package jh.thread.executor;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 17020751 on 2018/4/6.
 */
public class ThreadPoolTest {

    @Test
    public void testThreadPool(){
        LinkedBlockingQueue lbq = new LinkedBlockingQueue();
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2,2,6l, TimeUnit.SECONDS, lbq);
        DoRunnable runnable1 = new DoRunnable(1,"thread-1");
        DoRunnable runnable2 = new DoRunnable(2,"thread-2");
        DoRunnable runnable3 = new DoRunnable(3,"thread-3");
        DoRunnable runnable4 = new DoRunnable(4,"thread-4");
        DoRunnable runnable5 = new DoRunnable(5,"thread-5");
        DoRunnable runnable6 = new DoRunnable(6,"thread-6");

        tpe.execute(runnable1);
        tpe.execute(runnable2);
        tpe.execute(runnable3);
        tpe.execute(runnable4);
        tpe.execute(runnable5);
        tpe.execute(runnable6);
        tpe.execute(runnable1);
        tpe.execute(runnable1);
    }
}
