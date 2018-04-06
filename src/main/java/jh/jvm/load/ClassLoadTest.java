package jh.jvm.load;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器
 *
 * Created by 17020751 on 2018/4/6.
 */
public class ClassLoadTest {
    public static void main(String[] args) throws Exception{
        final ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return  defineClass(name,b,0,b.length);

                } catch (IOException e) {
                   throw new ClassNotFoundException(name);
                }
            }
        };

        Class c = myLoader.loadClass("jh.jvm.load.A");
        Object obj = c.newInstance();
        System.out.println("====");
    }
}
