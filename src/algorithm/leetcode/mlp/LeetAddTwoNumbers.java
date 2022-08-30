package algorithm.leetcode.mlp;

import algorithm.TestCase;


public class LeetAddTwoNumbers implements TestCase {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        result.val=(l1.val+l2.val)%10;
        int red = (l1.val+l2.val)/10;

        while(l1.next!=null||l2.next!=null){

        }

        return result;
    }

    @Override
    public void test() {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
