package jh.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 17020751 on 2018/4/23.
 */
public class Search10MinInArrays {

    int[] arrays = {1,3,5,6,7,8,9,111,34,54,34,34,1};
    //寻找最小的k个数
    // o(n) = n * (k * k/2) = n
    @Test
    public void minK(){
        int[] k = new int[5];
        k = Arrays.copyOfRange(arrays,0,5);
        insert(k);
        for (int i = k.length; i < arrays.length ; i++) {
            if(arrays[i] <= k[0]){
                k[0] = arrays[i];
                insert(k);
            }
        }
        System.out.println(k);
    }
    public void insert(int[] k){
        for (int i = 1; i < k.length; i++) {
            for (int j = i ;j>0 && k[j] > k[j-1]; j--) {
                int temp = k[j-1];
                k[j-1] = k[j];
                k[j] = temp;
            }
        }
    }
}
