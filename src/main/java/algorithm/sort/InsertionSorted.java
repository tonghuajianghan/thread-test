package algorithm.sort;

/**
 * 插入排序
 *
 * 插入排序不会访问索引右侧的元素
 * 选择排序不会访问索引左侧的元素
 * i 为索引
 *
 * Created by 17020751 on 2018/3/14.
 */
public class InsertionSorted extends  Sorted{

    public static void sorted(int[] array){
        for(int i=1;i<array.length;i++){//为什么从1开始,主体必须为一个数组,因此才从1开始(只有主体是数组,才能插入啊)
            for(int j=i;j > 0 &&less(array[j],array[j-1]);j--){
                exchange(array,j,j-1);
            }
        }

    }

    public static void main(String[] args) {
        int[] array = { 5,4,10,23,13,67,45};
        sorted(array);
        show(array);
    }
}
