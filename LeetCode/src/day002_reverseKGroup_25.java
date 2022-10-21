public class day002_reverseKGroup_25 {
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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode start = head;
        ListNode end = getK(start, k);
        if (end==null){
            return start;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next!=null){
            lastEnd = start.next;
            end = getK(lastEnd, k);
            if (end==null){
                break;
            }
            reverse(lastEnd,end);
            start.next=end;
            start = lastEnd;
        }
        return head;
    }

    public ListNode getK(ListNode start,int k){
        while (--k!=0&&start!=null){
            start = start.next;
        }
        return start;
    }

    public ListNode reverse(ListNode start,ListNode end){
        end = end.next;
        ListNode cur = start;
        ListNode next = null;
        ListNode pre = null;
        while (cur!=end){
            next = cur.next;
            cur.next = pre;
            pre=cur;
            cur=next;
        }
        start.next=end;
        return pre;
    }
}
