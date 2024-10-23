//Problem Link : https://leetcode.com/problems/cousins-in-binary-tree-ii/description/?envType=daily-question&envId=2024-10-23

//Solution 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    // List to store the sum of node values at each depth
    private List<Integer> depthSum;

    public TreeNode replaceValueInTree(TreeNode root) {
        depthSum = new ArrayList<>();
        // First DFS to calculate depth sums
        dfs1(root, 0);
        // Second DFS to replace values, starting with 0 for the root
        dfs2(root, 0, 0);
        // Return the modified root
        return root;
    }

    // First DFS to calculate the sum of node values at each depth
    private void dfs1(TreeNode root, int d) {
        if (root == null) return;  // Base case: if the node is null, return

        // If the current depth is greater than or equal to the list size,
        // add a new element with the current node's value
        if (d >= depthSum.size()) {
            depthSum.add(root.val);
        }
        // Otherwise, add the current node's value to the existing sum at this depth
        else {
            depthSum.set(d, depthSum.get(d) + root.val);
        }

        // Recursively call dfs1 for left and right children, incrementing the depth
        dfs1(root.left, d + 1);
        dfs1(root.right, d + 1);
    }

    // Second DFS to replace node values
    private void dfs2(TreeNode root, int val, int d) {
        if (root == null) return;  // Base case: if the node is null, return

        // Replace the current node's value with the passed 'val'
        root.val = val;

        // Calculate the sum of cousin nodes' values
        // If there's a next depth, get its sum, otherwise use 0
        int c = d + 1 < depthSum.size() ? depthSum.get(d + 1) : 0;
        // Subtract the values of the current node's children (if they exist)
        c -= (root.left != null ? root.left.val : 0);
        c -= (root.right != null ? root.right.val : 0);

        // Recursively call dfs2 for left and right children
        // Pass the calculated cousin sum 'c' and increment the depth
        if (root.left != null) dfs2(root.left, c, d + 1);
        if (root.right != null) dfs2(root.right, c, d + 1);
    }
}
