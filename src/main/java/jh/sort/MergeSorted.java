package jh.sort;

/**
 * Created by 17020751 on 2018/3/15.
 */
public class MergeSorted {

    public static void merge(int[] a,int start,int end){//中间拆分数组,有序合并拆分后的数组
        if(start >= end){
            return;
        }

        //将a[start,mid]与a[mid+1,end]归并
        int length = end -start;
        int mid = length/2 + start;
        int start1 = start;//第一个数组索引
        int end1 =mid;
        int start2 = mid + 1;//第二个数组索引
        int end2 = end;

        merge(a,start1,end1);
        merge(a,start2,end2);

        int[] au = new int[a.length];//辅助数组
        for (int k = 0; k < a.length; k++) {
            au[k] = a[k];
        }

        for (int k = start; k <= end; k++) {
            if(start1>end1){//数组1越界
                a[k] = au[start2++];
            }else if(start2 > end2){//数组2越界
                a[k] = au[start1++];
            }else if(au[start1] < au[start2]){
                a[k] = au[start1++];
            }else {
                a[k] = au[start2++];
            }
        }

    }


    public static void main(String[] args) {
        int[] a = {2,1,55,6,8,9,45,12,34,78,98,14};
        merge(a,0,a.length-1);
        Sorted.show(a);
    }
}
