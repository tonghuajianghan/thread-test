package jh.leetcode;

import org.junit.Test;

/**
 * Created by 17020751 on 2018/3/17.
 */
public class No2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode target = new ListNode(0);
        ListNode p = l1,q=l2,curr = target;int sum=0,carry=0;
        while(p != null && q != null){
            sum = p.val + q.val + carry;
            carry = 0;
            if(sum/10 >= 1){
                carry = sum/10;
                sum = sum%10;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            p = p.next;
            q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(1);
        }
        return  target.next;
    }

    @Test
    public void tt(){
        System.out.println(5/10);
        ListNode l1 = new ListNode(3);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(5);
        l2.next = l22;
        l22.next = l23;
        ListNode l = addTwoNumbers(l1,l2);
        System.out.println(l.val);

    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;

    }


}
