package jh.thread.executor;

/**
 * Created by 17020751 on 2018/4/6.
 */
public class DoRunnable implements Runnable{

    private int age;
    private String name;

    public DoRunnable(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("传过来的参数:" + " age:" + age +" name:" + name);
        try {
            Thread.sleep(11000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
