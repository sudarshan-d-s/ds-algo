package linkedlists;

/**
 * 
 * @author sudarshanshinde
 * <p>See <a href="https://leetcode.com/problems/reverse-linked-list/">https://leetcode.com/problems/reverse-linked-list/</a>
 * <br><br>
 * <h1>Problem Statement :</h1>
 * <p>Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 */


public class ReverseLL {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		while (null != head) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	class ListNode {
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
