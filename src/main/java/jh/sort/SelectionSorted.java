package jh.sort;

/**
 * 选择排序
 *
 * 名字由来:总是选择尾数组中最小的元素与指针指向元素交换
 *
 * 对于元素为n的数组,选择排序需要n^2/2次比较,n次交换
 *
 * 原地排序算法
 *
 * 主体是一个元素,这个元素是被操作的
 *
 * Created by 17020751 on 2018/3/14.
 */
public class SelectionSorted extends Sorted{

    public static void sorted(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min = i;//设第一个为最小元素
            for (int j = i+1; j < array.length; j++) {//第一个元素与从第二个开始的数组比较,比较出最小值,替换第一个
                if(less(array[i],array[j])){//遍历-交换-找到最小值
                    exchange(array,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 5,4,10,23,13,67,45};
        sorted(array);
        show(array);
    }
}
