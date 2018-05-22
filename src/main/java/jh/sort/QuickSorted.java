package jh.sort;

/**
 * 快速排序
 * 分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）
 *
 * Created by 17020751 on 2018/3/16.
 */
public class QuickSorted extends Sorted{

    public  static int partition(int[] a,int lo,int hi){
        int i = lo;
        int j = hi + 1;
        while (true){
            while (a[++i] < a[lo]) if(i == hi) break;
            while (a[--j] > a[lo]) if(j == lo)break;
            if(i>=j)break;
            exchange(a,i,j);
        }
        exchange(a,lo,j);//j为切分点,此时j点左边的都比j点小,右边的都比j点大,因此使用j点为分割点
        return j;
    }

    public static void sorted(int a[],int lo,int hi){
        if(hi <= lo){
            return;
        }
        int j = partition(a,lo,hi);
        sorted(a,lo,j);//这种分治的思想遇到很多次了,应该仔细想想这个.
        sorted(a,j+1,hi);
    }

    public static void main(String[] args) {
        //int[] a = {2,1,55,6,8,9,45,12,34,78,98,14};
        int[] a = {2,1};
        sorted(a,0,a.length-1);
        Sorted.show(a);

        int i= 0,j=2;
        while (i++ > 5){
            int z = i;
        }
    }
}
