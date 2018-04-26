package jh.leetcode;

import org.junit.Test;

/**
 * Longest Substring Without Repeating Characters
 *
 * Created by 17020751 on 2018/3/20.
 */
public class No3_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        String minSub = new String();
        for (int i = 0; i < s.length(); i++) {
            String curSub = new String();;
            for (int j = i; j < s.length(); j++) {
                //替换
                if(-1 == curSub.indexOf(s.charAt(j))){
                    curSub = s.substring(i,j+1);
                }else {
                    j = s.length();//找到最大不重复子字符串,停止循环
                }
            }
            //是否最大sub
            if(curSub.length() > minSub.length()){
                minSub = curSub;
            }
        }
        //不包含相同
        if(minSub.length() <= 0){
            return s.length();
        }
        return minSub.length();
    }

    //Given "abcabcbb", the answer is "abc", which the length is 3.
    @Test
    public void test(){
        String a = "aab";
        System.out.println(lengthOfLongestSubstring(a));
    }
}
