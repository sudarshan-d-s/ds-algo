package linkedlists;

import java.util.PriorityQueue;

/**
 * 
 * @author sudarshanshinde
 * <p>See <a href="https://leetcode.com/problems/merge-k-sorted-lists/">https://leetcode.com/problems/merge-k-sorted-lists/</a>
 * <br><br>
 * <h1>Problem Statement :</h1>
 * <p>You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode mergedNode = new ListNode();

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b)-> a.val - b.val);

        for(ListNode l : lists){
            if(null != l)
                minHeap.offer(l);
        }
        
        ListNode prev = mergedNode;
        while(!minHeap.isEmpty()){
            prev.next = minHeap.poll();
            prev = prev.next;
            if(null != prev.next){
                minHeap.offer(prev.next);
            }
        }
        
        return mergedNode.next;
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
