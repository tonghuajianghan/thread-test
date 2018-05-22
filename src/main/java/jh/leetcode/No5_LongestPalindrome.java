package jh.leetcode;

import org.junit.Test;

/**
 * Created by 17020751 on 2018/5/3.
 */
public class No5_LongestPalindrome {
    // O(n^3)
    public String longestPalindrome(String s) {
        String pSub = "";
        for (int i = 0; i < s.length(); i++) { // n
            String curSub = "";
            String fcurSub = "";
            for (int j = i; j < s.length(); j++) { //n
                curSub = s.substring(i,j+1);
                fcurSub = new StringBuilder(curSub).reverse().toString(); //n
                if(curSub.equals(fcurSub)){
                    if(pSub.length() < curSub.length()){
                        pSub = curSub;
                    }
                }
            }
        }
        return  pSub;
    }


    public String longestPalindrome2(String s) {
        String pSub = "";
        for (int i = 0; i < s.length(); i++) { // n
            String curSub = "";
            if(s.length()==1){
                curSub = s.substring(0,1);
            }else if(s.length() == 2){
                if(s.charAt(0) == s.charAt(1)){
                    curSub = s;
                }
            }else if(s.length() == 3 && s.charAt(0) == s.charAt(1) && s.charAt(0) == s.charAt(2)){
                curSub = s;
            }
            else if(i == s.length()-1 && pSub == ""){
                pSub =  s.substring(0,1);
            }
            else if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){//偶对称
                for (int l = i,t =i+1;l >= 0 && t <s.length(); l--,t++) {
                    if(s.charAt(l) == s.charAt(t)){
                        curSub = s.substring(l,t+1);
                    }else {
                        l=-1;//中断for循环
                    }
                }
            }
            else if(i>=1 && i<s.length()-1 && s.charAt(i-1) == s.charAt(i+1)){//奇对称
                for (int l = i-1,t=i+1; l >= 0 && t <s.length(); l--,t++) {
                    if(s.charAt(l) == s.charAt(t)){
                        curSub = s.substring(l,t+1);
                    }else {
                        l=-1;//中断for循环
                    }
                }
            }

            if(pSub.length() < curSub.length()){
                pSub = curSub;
            }
        }
        return  pSub;
    }

    public String longestPalindrome3(String s) {
        String rs = new StringBuilder(s).reverse().toString(); //n
        String pSub = "";
        String curSub = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < rs.length(); j++) {
                if(s.charAt(i) == rs.charAt(j)){//
                    curSub+= s.charAt(i);
                }else {

                }

            }
        }
        return pSub;
    }

    @Test
    public void t(){
        System.out.println( longestPalindrome2("ccc"));
    }
}
