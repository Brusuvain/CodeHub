public class MergeKSortedListss {

    public static int mergeLists2PairsAtATime(ListNode[] lists) {
        int i = 0;
        int count = 0;
        while (i < lists.length) {
            //continue till a non null listK
            while (i<lists.length && lists[i] == null) {
                ++i;
            }
            if (i == lists.length) {
                break;
            }
            // Storing the index of the first Linked list
            int l1 = i++;
            //Check to prevent Array Out of Bounds Exception
            if (i == lists.length) {
                //incrementing the counter here for the last remaining list in the
                // Array which couldnt be paired in this iteration
                ++count;
                break;
            }
            //continue till a non null list
            while (i<lists.length && lists[i] == null) {
                ++i;
            }
            if (i == lists.length) {
                break;
            }
            int l2 = i;
            merge2lists(lists, l1, l2);
            // counting Number of merges which is equal to the number of remaning lists
            ++count;
        }
        return count;
    }

    public static ListNode mergeKlists(ListNode[] lists) {
        int remaining = 0;
        //checking for only 1 remainging list in the Array
        while (remaining != 1) {
            remaining = mergeLists2PairsAtATime(lists);
        }

        return lists[0];
    }



    public static void merge2lists(ListNode[] Lists, int first, int second) {
        //local variables for processing
        ListNode l1 = Lists[first];
        ListNode l2 = Lists[second];
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        head.next = null;
        ListNode store = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;

            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
            head.next = null;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        l1 = store;
        l2 = null;
        head = null;
        //storing back the merged lists back in the array
        Lists[first] = l1;
        //l2 will always be null
        Lists[second] = l2;
    }

    public static void main(String args[]) {
        ListNode dummy = new ListNode(3);
        ListNode l1 = dummy;
        dummy.next = new ListNode(4);
        dummy = dummy.next;
        dummy.next = new ListNode(6);
        dummy = dummy.next;
        ListNode dummy2 = new ListNode(2);
        ListNode l2 = dummy2;
        dummy2.next = new ListNode(5);
        dummy2 = dummy2.next;
        ListNode l3=new ListNode(4);
        ListNode[] lists = new ListNode[]{l1,l2,l3};
        mergeKlists(lists);
        l1 = lists[0];
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

    static class ListNode {
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
