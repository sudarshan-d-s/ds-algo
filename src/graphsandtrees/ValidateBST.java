package graphsandtrees;


/**
 * 
 * @author sudarshanshinde
 * <p>See <a href="https://leetcode.com/problems/validate-binary-search-tree/">https://leetcode.com/problems/validate-binary-search-tree/</a>
 * <br><br>
 * <h1>Problem Statement :</h1>
 * 
 * <p>Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p><p>A valid BST is defined as follows:
 * <ul>
 * <li>The left subtree of a node contains only nodes with keys less than the node's key.</li>
 * <li>The right subtree of a node contains only nodes with keys greater than the node's key.</li>
 * <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 *
 */

public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if (null == root) {
			return true;
		}

		if ((null != min && root.val <= min) || (null != max && root.val >= max)) {
			return false;
		}

		if (null != root.left && root.left.val >= root.val) {
			return false;
		}

		if (null != root.right && root.val >= root.right.val) {
			return false;
		}

		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
}

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
