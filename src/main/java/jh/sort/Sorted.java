package jh.sort;

/**
 *  排序包括两种基本操作
 *      1.比较
 *      2.交换
 *
 *  排序算法基于额外内存使用可以分为两类:
 *      原地排序算法:不需要额外内存
 *      其他排序算法:需要额外内存
 *
 * Created by 17020751 on 2018/3/14.
 */
public class Sorted {

    //比较
    public static boolean less(int a,int b){
        return a<b?true:false;
    }

    //交换
    public static void exchange(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void show(int [] a){
        String show = "";
        for(int i:a){
            show += i + ",";
        }
        System.out.println(show);
    }
}
