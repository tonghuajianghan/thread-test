package jh.thread.sample;

import org.junit.Test;

public class RunTest {
	@Test
	public void testThread(){
		ThreadTest tt = new ThreadTest();
		tt.start();
		System.out.println("main end ...");
		
		//运行结果
		// main end ...
		// thread test run ...
		//说明多线程中，代码运行结果与代码执行顺序无关。
		
	}
}
