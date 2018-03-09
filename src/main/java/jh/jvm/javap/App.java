package jh.jvm.javap;

/**
 * Created by 17020751 on 2018/1/30.
 */
public class App {
    public final static int fff = 44;
    public static int fffh = 44;


    public static void main(String[] args) {
        int i = 2;
        int h = 3;
        System.out.println((byte)'j');
        System.out.println(((byte)'h'));
    }

    public int add12and13(){
        int i =1;
        int j = 2;
        B b = new B();
        b.f();

        return addTwo(1,2);
    }

    public int addTwo(int h ,int y){
        return h+y;
    }
}

class B{
    public void f(){
        int f = 0;
    }
}
