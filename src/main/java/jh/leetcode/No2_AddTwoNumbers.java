package jh.leetcode;

/**
 * Created by 17020751 on 2018/3/17.
 */
public class No2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode target = new ListNode(0);
        ListNode p = l1,q=l2,curr = target;int sum=0,carry=0;
        while(p != null || q != null){
            int nump = p==null?0:p.val;
            int numq = q==null?0:q.val;
            sum = nump + numq + carry;
            carry = 0;
            if(sum/10 >= 1){
                carry = sum/10;
                sum = sum%10;
            }
            curr.next = new ListNode(sum);//处理对象属性next指向
            curr = curr.next;//处理对应引用curr的指向
            if(p !=null){
                p = p.next;
            }
            if(q !=null){
                q = q.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(1);
        }
        return  target.next;
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
