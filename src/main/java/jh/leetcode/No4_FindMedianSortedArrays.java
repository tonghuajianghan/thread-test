package jh.leetcode;

import org.junit.Test;

/**
 * Created by 17020751 on 2018/3/20.
 */
public class No4_FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double r;
        if(nums1.length == 0){
            if((nums2.length)%2 == 0){
                r = (double) (nums2[(nums2.length-1)/2] + nums2[(nums2.length-1)/2 +1])/2;
            }else {
                r = nums2[(nums2.length-1)/2];
            }
            return r;
        }
        if(nums2.length == 0){
            if((nums1.length)%2 == 0){
                r = (double) (nums1[(nums1.length-1)/2] + nums1[(nums1.length-1)/2 +1])/2;
            }else {
                r = nums1[(nums1.length-1)/2];
            }
            return r;
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j] < nums1[i]){
                    int temp = nums1[i];
                    nums1[i] = nums2[j];
                    nums2[j] = temp;
                    break;
                }
            }
        }
        int length = nums1.length + nums2.length;
        if((length)%2 == 0){
            r= (double) (nums1[(nums1.length-1)] + nums2[0])/2;
        }else {
            if(nums1.length < nums2.length){
                r = nums2[0];
            }else {
                r=  nums1[nums1.length-1];
            }
        }
        return r;
    }

    @Test
    public void test(){
      int[]  nums1 = {1, 2};
      int[]  nums2 = {1,1};
      double r = new No4_FindMedianSortedArrays().findMedianSortedArrays(nums1,nums2);
      System.out.println(r);
    }
}
