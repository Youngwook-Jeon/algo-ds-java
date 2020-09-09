package problems.leetcode;

class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) return root;
        Node leftNode = root.left;
        Node rightNode = root.right;
        leftNode.next = rightNode;
        rightNode.next = (root.next == null) ? null : root.next.left;
        Node node1 = connect(leftNode);
        Node node2 = connect(rightNode);

        return root;
    }

    // Definition for a Node.
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
