package jh.callback;

/**
 * 回调函数
 * <a>http://gaocegege.com/Blog/java/java-callback</a>
 *
 * @author JiangHan
 */
public class CallBackTest {
	public static void main(String[] args) {
		CallBacked backed = new CallBacked();
		backed.a();
	}
}

interface CallBackUnit {//通过接口来实现回调
	public void callbackFunc(String param);
}

class CallBacker {//回调函数
	public String param;
	
	public void b(CallBackUnit callBackUnit) {
		// some operations
		System.out.println("方法b...");
		callBackUnit.callbackFunc(param);//这个位置就是回调了
		// some operations
	}
}

class CallBacked {
	public void a() {
		CallBacker callBacker = new CallBacker();
		callBacker.param = "param----";
		callBacker.b(new CallBackUnit() {
			@Override
			public void callbackFunc(String param) {//在方法b中调用执行的
				System.out.println(param);
				System.out.println("end back!!!");
			}
		});
	}
}
