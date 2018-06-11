package jh;

import java.io.*;

/**
 * Created by 17020751 on 2018/6/11.
 */
public class Note {

    public static void main(String[] args) throws IOException {
        copyFolder(new File("D:\\Note"),new File("D:\\Note\\blog\\source\\_posts"));
        //new File("D:\\yy\\ttt").delete();
        //deleteDir(new File("D:\\yy\\ttt"));
    }

    public static void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            String files[] = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                if(srcFile.getName().equals("blog")){
                    continue;
                }
                if(srcFile.getName().contains(".git")){
                    continue;
                }
                if(srcFile.getName().contains("company")){
                    continue;
                }
                if(srcFile.getName().contains(".doc")){
                    continue;
                }
                if(srcFile.getName().contains(".chm") || srcFile.getName().contains(".CHM")){
                    continue;
                }
                // 递归复制
                copyFolder(srcFile, dest);
            }
        } else {
            System.out.println(src.getName());
            InputStream in = new FileInputStream(src);
            File destFile = new File(dest, src.getName());
            OutputStream out = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];

            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        }
    }

    // 删除某个目录及目录下的所有子目录和文件
    public static boolean deleteDir(File dir) {
        // 如果是文件夹
        if (dir.isDirectory()) {
            // 则读出该文件夹下的的所有文件
            String[] children = dir.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                // File f=new File（String parent ，String child）
                // parent抽象路径名用于表示目录，child 路径名字符串用于表示目录或文件。
                // 连起来刚好是文件路径
                boolean isDelete = deleteDir(new File(dir, children[i]));
                // 如果删完了，没东西删，isDelete==false的时候，则跳出此时递归
                if (!isDelete) {
                    return false;
                }
            }
        }
        // 读到的是一个文件或者是一个空目录，则可以直接删除
        return dir.delete();
    }
}
