package jh.thread.runnableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class FutureTaskTest {
	Executor e = Executors.newCachedThreadPool();
	ExecutorService es = Executors.newSingleThreadExecutor();
	Callable<String> c = new Callable<String>() {
		
		@Override
		public String call() throws Exception {
			//System.out.println("callable 1...");
			return "callable 1...";
		}
	};
	
	/**
	 *  因为FutureTask继承自Runnable，所以也可以由executor执行(当做一个Runnable一样)
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	@Test
	public void test1() throws InterruptedException, ExecutionException{
		FutureTask<String> ft = new FutureTask<String>(c);
		es.execute(ft);
		System.out.println(ft.get().toString());
	}
	
	
	@Test
	public void test2() throws InterruptedException, ExecutionException{
		FutureTask<String> ft = new FutureTask<String>(c);
		es.execute(ft);
		System.out.println(ft.get().toString());
	}
	
	
}
