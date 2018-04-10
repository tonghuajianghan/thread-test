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

    //冒泡
    public static void bubbleSort(int[] arr) {
        int i, temp, len = arr.length;
        boolean changed;
        do {
            changed = false;
            for (i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    changed = true;
                }
            }
        } while (changed);
    }
}
