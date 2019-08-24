package algorithm.leetcode;

import org.junit.Test;

/**
 * Created by 17020751 on 2018/3/20.
 */
public class No4_FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double r;
        //构造
        int[] a = new int[nums1.length + nums2.length];
        for (int i = 0; i < a.length; i++) {
            if(i<nums1.length){
                a[i] = nums1[i];
            }else {
                a[i] = nums2[i-nums1.length];
            }
        }
        //选择排序
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[j]<a[i]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        //计算
        if(a.length%2==0){
           r =(double) (a[a.length/2-1] + a[a.length/2])/2;
        }else {
            r = (double)a[a.length/2-1];
        }
        return r;
    }

    @Test
    public void test(){
      int[]  nums1 = {};
      int[]  nums2 = {2,3};
      double r = new No4_FindMedianSortedArrays().findMedianSortedArrays(nums1,nums2);
      System.out.println(r);
    }
}
