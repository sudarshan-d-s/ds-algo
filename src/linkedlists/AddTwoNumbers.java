package linkedlists;


/**
 * 
 * @author sudarshanshinde
 * <p>See <a href="https://leetcode.com/problems/add-two-numbers/">https://leetcode.com/problems/add-two-numbers/</a>
 * <br><br>
 * <h1>Problem Statement :</h1>
 * 
 * <p>GYou are given two non-empty linked lists representing two non-negative integers. 
 * <p>The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * <p>Add the two numbers and return the sum as a linked list. 
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * 
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode prev = null;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
			carry = sum / 10;

			ListNode node = new ListNode(sum % 10);

			if (null == prev) {
				head = node;
			} else {
				prev.next = node;
			}
			prev = node;
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}

		if (carry > 0)
			prev.next = new ListNode(carry);

		return head;
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
