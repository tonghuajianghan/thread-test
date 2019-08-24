package algorithm.leetcode;

/**
 * Created by 17020751 on 2017/11/29.
 */
public class No1_TowSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i < nums.length; i++){
            for(int j=0;j < nums.length; j++){
                if(i != j){
                    if(nums[i] + nums[j] == target){
                        return new int[]{i,j};
                    }
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
