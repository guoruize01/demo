package everyday;

public class test4 {
    private static class ListNode{
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        int[] a= new int[]{1,2,2,1};
        ListNode pre= new ListNode(0);
        ListNode head =pre;
        for (int i = 0; i < a.length; i++) {
            ListNode cur = new ListNode(a[i]);
            pre.next = cur;
            pre = pre.next;
        }
        head = head.next;
        while(head!=null){
            System.out.println(head.val);
            head= head.next;
        }
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode dumppy = new ListNode(0,head);
        ListNode slow = dumppy;
        ListNode fast= head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);
        // while(head!=null){
        //     System.out.println(head.val);
        //     head = head.next;
        // }
        ListNode right = slow.next;
        ListNode left = head;
        while(right!=null){
            // System.out.println(right.val);
            // System.out.println(left.val);
            if(left!=right){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
