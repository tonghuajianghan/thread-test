package jh.jvm.allocation;

/**
 * 分配内存
 * 
 * @author JiangHan
 *
 */
public class TestAllocation {
	/**
	 * vm 参数需要
	 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * 
	 */
	private static int _1MB = 1024*1024;
	
	public static void main(String[] args) {
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 = new byte[2*_1MB];
		allocation2 = new byte[2*_1MB];
		allocation3 = new byte[2*_1MB];
		allocation4 = new byte[4*_1MB];
	}
	
	
}
