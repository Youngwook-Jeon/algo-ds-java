package problems.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode left = l1, right = l2, dummy = new ListNode(0);
        int overDigit = 0;
        ListNode cur = dummy;
        while (left != null || right != null) {
            int digit1 = (left != null) ? left.val : 0;
            int digit2 = (right != null) ? right.val : 0;
            int nextDigit = digit1 + digit2 + overDigit;
            overDigit = nextDigit / 10;
            cur.next = new ListNode(nextDigit % 10);
            cur = cur.next;
            if (left != null) left = left.next;
            if (right != null) right = right.next;
        }

        if (overDigit == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }

    public static class ListNode {
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
