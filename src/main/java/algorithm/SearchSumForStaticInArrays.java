package algorithm;


/**
 * 输入两个整数n和sum，从数列1，2，3.......n 中随意取几个数，
 * 使其和等于sum，要求将其中所有的可能组合列出来。
 *
 * 典型的0-1背包问题
 *
 * Created by 17020751 on 2018/4/24.
 */
public class SearchSumForStaticInArrays {

    //算法思想：考虑是否取第n个数，
    // 问题可以转化为前n-1个数和为sum-a[n-1]的问题，也可以转化为后n-1个数的求和问题。使用递归思想解决。
    //如果取第n个数，即求得前n-1个数满足和为sum-a[n-1]的问题
    //如果不取第n个数，即求得前n-1个数满足和为sum的问题
    static void sumOfkNumber(int arrays[],int n,int sum,int[] flag){//取第n个数
        if(n <= 0 || sum <= 0){
            return;
        }
        if(arrays[n] == sum){//递归最后一个选中情况
            flag[n] = 1;
            for (int i = 0; i < flag.length; i++) {
                if(flag[i] == 1){
                    System.out.print(arrays[i] + ",");
                }
            }
            System.out.println("");
            flag[n] = 0;
        }

        //取出第n个数
        flag[n] = 1;
        sumOfkNumber(arrays,n-1,sum-n,flag);

        //不取第n个数
        flag[n] = 0;
        sumOfkNumber(arrays,n-1,sum,flag);

    }

    public static void main(String[] args) {
        int arrays[] = {0,1,2,3,4,5,6,7,8,9};
        int n = 5;
        int sum =6;
        int[] flag = new int[n + 1];
        sumOfkNumber(arrays,n,sum,flag);
    }
}
