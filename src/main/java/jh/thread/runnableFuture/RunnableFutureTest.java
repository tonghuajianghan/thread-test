package jh.thread.runnableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

/**
 * 感觉RunnableFuture类==Callable类
 * 
 * @author JiangHan
 *
 */
public class RunnableFutureTest {

	Executor e = Executors.newCachedThreadPool();
	ExecutorService es = Executors.newSingleThreadExecutor();

	/**
	 * 因为Runnable继承自Runable，因此也可以像Runnable一样使用
	 * 
	 * 因为继承了Future，因此可以让Runable方式启动的线程，返回结果
	 * 
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	@Test
	public void test1() throws InterruptedException, ExecutionException{
		RunnableFuture rf = new MyRunnableFuture();
		new Thread(rf).start();
		System.out.println(rf.get().toString());
	}
	
}

class MyRunnableFuture implements RunnableFuture<String>{
	private String result = "my ...";
	
	//================================= Future 方法==========================================
	
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String get() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return result += "get...";
	}

	@Override
	public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return result += "get...";
	}
	
	//===============================================  Runnable 方法====================================================

	@Override
	public void run() {
		System.out.println("my runnable future ...");
		result += " run ...";
		
	}
	
}