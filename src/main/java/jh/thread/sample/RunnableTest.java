package jh.thread.sample;

/**
 * 	1.run()方法：
 *       	直接调用run()方法其实就是普通的方法调用。此时依然只有main这个主线程，和多线程没什么关系。
 *	2.start()方法：
 *       	调用start()方法时，才是启动了一个线程，线程此时为就绪状态，一旦获得CPU时间片，
 *       	此时jvm会自动去调用相应的run()方法，进入运行状态。
 *
 *
 * @author JiangHan
 */
public class RunnableTest {

	
//	public static void main(String[] args) {
//		MyThread mt = new MyThread();
//		mt.run();
//		mt.run();
//		//new Thread(mt).start();
//		System.out.println("this is main ...");
//	}
	
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		new Thread(mt).start();
		//new Thread(mt).start();
		System.out.println("this is main ...");
	}
	
}

class MyThread implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * 
	 * 多线程调用,方法体执行
	 * 
	 */
	public void run() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//这个里面的东西可以多线程调用,即
		//这个就是多线程的方法体
		//多线程运行
		System.out.println("my thread do ...");
	}
	
}
