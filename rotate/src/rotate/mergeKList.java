package rotate;

import java.util.*;

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

public class mergeKList {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
	 * ListNode next) { this.val = val; this.next = next; } }
	 */
	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			ListNode head = new ListNode();
			List<Integer> huh = new ArrayList<>();
			ListNode headCopy = head;
			ListNode temp = null;
			int breakOff = lists.length;
			int minI = -1;
			while (breakOff > 0) {
				ListNode min = new ListNode(10001);
				for (int i = 0; i < lists.length; i++) {
					if (huh.contains(i))
						continue;
					if (breakOff == 0) {
						break;
					}
					if (lists[i] == null) {

						// System.out.println(breakOff);
						if (!huh.contains(i)) {
							huh.add(i);
							--breakOff;
						}
						continue;
					}
					// System.out.print(" "+lists[i].val+" mv is "+min.val);
					if (lists[i].val <= min.val) {
						min = lists[i];
						minI = i;

					}

				}
				if (breakOff == 0)
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
}
