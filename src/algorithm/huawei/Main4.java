import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class Main4 {

    public static void main (String [] args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode res = sum(l1, l2);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    private static ListNode sum(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        int carry = 0;
        while(l1!=null || l2!=null){
            int sum1 = l1==null ? 0 : l1.val;
            int sum2 = l2==null ? 0 : l2.val;
            int total = sum1 + sum2 + carry;
            carry = total / 10;
            int sum = total % 10;
            curr.next = new ListNode(sum);
            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
            curr = curr.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
