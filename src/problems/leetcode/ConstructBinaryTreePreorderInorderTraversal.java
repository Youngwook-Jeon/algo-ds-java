package problems.leetcode;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreePreorderInorderTraversal {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(preorder, 0, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int ind = map.get(preorder[preStart]);
        node.left = helper(preorder, preStart + 1, inorder, inStart, ind - 1);
        node.right = helper(preorder, preStart + ind - inStart + 1, inorder, ind + 1, inEnd);

        return node;
    }

    private static class TreeNode {
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
}
