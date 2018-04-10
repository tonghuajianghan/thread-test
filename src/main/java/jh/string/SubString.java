package jh.string;

/**
 * Created by 17020751 on 2018/4/10.
 */
public class SubString {

    // 暴力子字符串查找
    // n+m < x < m(n-m + 1) 查找长度
    public static int subSring(String pat,String txt){
        int n = txt.length();
        int m = pat.length();
        for (int i = 0; i < n; i++) {//指针i跟踪文本
            int j;//指针j跟踪模式
            for (j = 0; j < m; j++) {
                if(txt.charAt(i + j) != pat.charAt(j)){
                    break;
                }
            }
            if(j == m){
                return i;
            }
        }
        return n;
    }

    //暴力子字符串查找
    //逆向回溯查找
    public static int subStringReverse(String pat,String txt){
        int i,n=txt.length();
        int j,m=pat.length();
        for(i=0,j=0;i<n&j<m;i++){
            if(txt.charAt(i) == pat.charAt(j))j++;
            else{
                i-=j;j=0;
            }
        }
        if(j==m)return i-j;
        else return n;
    }

    public static void main(String[] args) {
        String txt = "abcdefg";
        String pat = "def";
        int j =subSring(pat,txt);
        System.out.println(j);

        int w =subStringReverse(pat,txt);
        System.out.println(w);

    }
}
