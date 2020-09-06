package problems.leetcode;

import java.util.*;


class BinaryTreeZigzagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int cnt = 1, zigZag = 0;
        while (!q.isEmpty()) {
            cnt = q.size();
            List<Integer> lst = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = q.poll();
                lst.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (zigZag % 2 == 1) {
                Collections.reverse(lst);
            }
            ret.add(lst);
            zigZag++;
        }

        return ret;
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
