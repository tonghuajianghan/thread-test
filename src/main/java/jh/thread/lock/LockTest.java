package jh.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * 学习lock接口下的类
 * 
 * @author JiangHan
 *
 */
public class LockTest {

	@Test
	public void testLock() {
		
		List<Integer> list = new ArrayList<Integer>(1000);
		System.out.println("list.size=" + list.size());
		for (int i = 0; i < 100; i++) {
			list.add(i, i);
		}

		for (int i = 0; i < 20; i++) {
			
			new Thread(new rru(list,i)).start();
		
			
		}

//		System.out.println("--------------------------------------------");
//		for (int i = 0; i < 100; i++) {
//			System.out.println(list.get(i));
//		}

	}
}


class rru implements Runnable{
	final Lock lock = new ReentrantLock();
	List<Integer> l ;
	int i;
	
	public rru(List<Integer> l,int i){
		this.l = l;
		this.i = i;
	}
	
	@Override
	public void run() {
		lock.lock();
		l.add(i);
		System.out.println(l.get(i));
		System.out.println("list.size=" + l.size());
		lock.unlock();
		
	}
	
	
	
	
	
}