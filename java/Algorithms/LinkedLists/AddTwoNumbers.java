public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class AddTwoNumbers{

    public void printls(ListNode l) {
        System.out.print("[");
        while(l != null) {
            System.out.print(l.val + ", ");
            l = l.next;
        }
        System.out.println("\b\b]\n");

    }

    public static ListNode reverseLinkedList(ListNode head) {

        ListNode next_node = new ListNode();
        ListNode prev = null;

            while (head != null) {
                next_node = head.next;
                head.next = prev;
                // For the next node:
                prev = head;
                head = next_node;
            }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        // First, check if we have k nodes to work with
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head; // Not enough nodes
            temp = temp.next;
        }

        this.printls(head);

        // Process the group
        ListNode prev = null;
        ListNode curr = head;

        // Reverse first k nodes
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Recursively process remaining groups
        head.next = reverseKGroup(curr, k);

        return prev;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int val1;
        int val2;
        int carry;
        int sum;
        int digit;

        carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            val1 = (l1 != null) ? l1.val : 0;
            val2 = (l2 != null) ? l2.val : 0;

            sum = val1 + val2 + carry;
            carry = sum / 10;
            digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return head.next;
    }

    public static void main(String[] args) {
        int [] q  = {5, 6, 0, 0, 0,0,0,0,0,0,0,0,0,0,0,2,3,4,8,9,6, 4};
        int [] p  = {1, 2, 3, 4, 5};

        AddTwoNumbers obj = new AddTwoNumbers();

        ListNode l1 = new ListNode(p[0]);

        ListNode current = l1;

        for (int i = 1; i < p.length; i++) {
            current.next = new ListNode(p[i]);
            current =  current.next;
        }

        ListNode l2 = new ListNode(q[0]);

        current = l2;

        for (int i = 1; i < q.length; i++) {
            current.next = new ListNode(q[i]);
            current =  current.next;
        }

        /* TESTS */
        // System.out.print("l1 ");
        // obj.printls(l1);

        obj.reverseKGroup(l1, 2);
        // obj.printls(obj.reverseKGroup(l1, 2));

    }
}
