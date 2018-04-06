package jh.struct.hash;

/**
 * hashCode()和equals()定义在Object类中，
 * 这个类是所有java类的基类，所以所有的java类都继承这两个方法
 * 
 * hashCode()方法被用来获取给定对象的唯一整数。这个整数被用来确定对象被存储在HashTable类似的结构中的位置。
 * 默认的，Object类的hashCode()方法返回这个对象存储的内存地址的编号。
 *
 * 注意
 * 	保证使用对象的同一个属性来生成hashCode()和equals()两个方法
 * 	equals方法必须保证一致（如果对象没有被修改，equals应该返回相同的值）
 * 	任何时候只要a.equals(b),那么a.hashCode()必须和b.hashCode()相等。
 *
 * @author JiangHan 17020751
 */
public class HashCodeTest {
	private String code;
	
	public static void main(String[] args) {
		String s = "1sdfawef";
		System.out.println(s.hashCode());
		Integer ab = 12354523;
		System.out.println(ab.hashCode());
		Float abf = 12354523.55f;
		System.out.println(abf.hashCode());
		//
		Object o = new Object();
		System.out.println("默认返回内存地址" + o.hashCode());
		
	}
	
	
	// ==================================  根据属性 自动生成   =================================================
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashCodeTest other = (HashCodeTest) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}
