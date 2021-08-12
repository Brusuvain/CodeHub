package rotate;

import java.util.*;

public class mergeKList {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
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

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode();
		List<Integer> nullIndexList = new ArrayList<>();
		ListNode headCopy = head;
		int noOfRemainingsNonNulls = lists.length;
		int minI = -1;
		while (noOfRemainingsNonNulls > 0) {
			// continue iterations till each LinkedList reaches null
			ListNode min = new ListNode(10001);
			for (int i = 0; i < lists.length; i++) {
				if (nullIndexList.contains(i))
					continue;
				if (lists[i] == null) {
					// Only decrease NonNulls counter first time a LinkedList reaches null
					if (!nullIndexList.contains(i)) {
						nullIndexList.add(i);
						--noOfRemainingsNonNulls;
					}
					continue;
				}
				// finding the minimum value node
				if (lists[i].val <= min.val) {
					min = lists[i];
					minI = i;

				}

			}
			// break if all nodes have been iterated over
			if (noOfRemainingsNonNulls == 0)
				break;
			head.next = new ListNode();
			head.next.val = min.val;
			head = head.next;
			if (lists[minI] != null)
				lists[minI] = lists[minI].next;
		}
		return headCopy.next;
	}
}
