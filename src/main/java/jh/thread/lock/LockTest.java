package jh.thread.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 学习lock接口下的类
 * 
 * @author JiangHan
 *
 */
public class LockTest {
	public List<Integer> list = new ArrayList<Integer>(10);
	private Lock lock = new ReentrantLock();

	public void add(int e) {
		lock.lock();//竞态资源,顺序访问
		list.add(e);
		System.out.println("add:" + e +"-----"+ "list.get(e)"+"--------" + Thread.currentThread().getName()+"-------" + "");
		lock.unlock();
	}

	@Test
	public void testLock() {
		for (int i = 0; i < 10; i++) {
			new Thread(new rru(this, i)).start();
		}
//		System.out.println("list.size=" + list.size());
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
	}

}

class rru implements Runnable {
	LockTest lt;
	int i;

	public rru(LockTest lockTest, int i) {
		this.lt = lockTest;
		this.i = i;
	}

	@Override
	public void run() {
		lt.add(i);
	}

}