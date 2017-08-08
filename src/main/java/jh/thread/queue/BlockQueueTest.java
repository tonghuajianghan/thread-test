package jh.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *			抛出异常		特殊值		阻塞		超时
 *	插入		add(e)		offer(e)	put(e)	offer(e,time,unit)
 *	移除		remove()	poll()		take()	poll(time,unit)
 *	检查		element()	peek()		不可用	不可用
 *
 * @author JiangHan 17020751
 */
public class BlockQueueTest {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(20);
		for (int i = 0; i < 20; i++) {
			bq.put(i);
			//System.out.println("bq 插入第" + i + "个" +"--------------"+ bq.poll());
		}
		for (int i = 0; i < 30; i++) {
			System.out.println("bq 大小" + bq.size());
			System.out.println("bq 获取第" + i + "个" +"--------------"+ bq.take());
		}
		
	}
}
