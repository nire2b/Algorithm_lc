public class day2_mergeTwoLists_21 {
    class ListNode{
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null||list2==null){
            return list1 ==null?list2:list1;
        }
        ListNode head = list1.val<=list2.val?list1:list2;
        ListNode cur = head;
        ListNode l1 = head.next;
        ListNode l2 = head == list1?list2:list1;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                cur.next=l1;
                cur = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        if (l1==null){
            cur.next=l2;
        }else {
            cur.next = l1;
        }
        return head;
    }
}
