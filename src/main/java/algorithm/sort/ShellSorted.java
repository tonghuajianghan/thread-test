package algorithm.sort;

/**
 * 希尔排序
 *
 *
 *
 *
 *
 * Created by 17020751 on 2018/3/15.
 */
public class ShellSorted extends Sorted{


    public static void sorted(int[] array){
        int n = array.length;
        int h = 1;//步长
        while (h < n/3)h = 3*h + 1;//起始排序位置,步长是逐渐减小的,直到步长为1为止
        while (h >= 1){
            for (int i = h; i < n; i++) {
                for (int j = i; j-h>=0 && less(array[j],array[j-h]); j-=h) { //j-h>=0最后一组不进行比较
                    exchange(array,j,j-h);
                }
            }
            h=h/3;
        }
    }

    public static void main(String[] args) {
        int[] array = { 5,4,10,23,13,67,67,45,456,789};
        //show(array);
        sorted(array);
        show(array);
    }
}
