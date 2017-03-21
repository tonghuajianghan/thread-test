package jh.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class FutureTest {
	@Test
	public void test1() throws InterruptedException, ExecutionException {
		App app = new App();
		app.show2("2--");
	}

}

interface ArchiveSearcher {
	String search(String target);
}

class App {
	//用来执行callable，执行者
	ExecutorService executor = Executors.newSingleThreadExecutor();
	ArchiveSearcher searcher = new ArchiveSearcher() {
		@Override
		public String search(String target) {
			return target;
		}
	};

	/**
	 * Future
	 * 
	 * 第一种运行方式，提价callable返回future
	 * 
	 * @param target
	 * @throws InterruptedException
	 */
	void showSearch(final String target) throws InterruptedException {
		//执行线程，结果返回给future
		Future<String> future = executor.submit(new Callable<String>() {
			public String call() {
				return "12345"; // searcher.search(target);
			}
		});
		
		displayOtherThings(); // do other things while searching
		try {
			displayText(future.get()); // use future
		} catch (ExecutionException ex) {
			cleanup();
			return;
		}
	}

	/**
	 * FutureTask
	 * 
	 * 第二种运行方式，新建FutureTask，直接执行FutureTask
	 * 因为FutureTask继承Runnable，所以可以直接执行
	 * 
	 * @param target
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	void show2(final String target) throws InterruptedException, ExecutionException {
		FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
			public String call() {
				return searcher.search(target);
			}
		});
		executor.execute(future);//执行线程，结果返回给future
		System.out.println("结束 execute方法");
		System.out.println(future.get().toString());
	}

	public void displayOtherThings() {
	}

	public void displayText(String result) {
		System.out.println(result);
	}

	public void cleanup() {
	}
}
