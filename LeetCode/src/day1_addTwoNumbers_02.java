public class day1_addTwoNumbers_02 {
    class ListNode{
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curL = listLength(l1)>=listLength(l2)?l1:l2;
        ListNode curS = listLength(l1)<listLength(l2)?l1:l2;
        ListNode l = curL;
        ListNode s = curS;
        ListNode last = null;
        int curNum = 0;
        int carryNum = 0;
        while (s!=null){
            curNum = l.val+s.val+carryNum;
            l.val = curNum %10;
            carryNum=curNum/10;
            last = l;
            l = l.next;
            s = s.next;

        }
        while (l!=null){
            curNum = l.val + carryNum;
            l.val = curNum%10;
            carryNum = curNum/10;
            last = l;
            l = l.next;
        }
        if (carryNum != 0){
            ListNode node = new ListNode(1);
            last.next = node;
        }

        return curL;
    }

    public int listLength(ListNode head){
        int size = 0;
        while (head!=null){
            head = head.next;
            size++;
        }
        return size;
    }
}
