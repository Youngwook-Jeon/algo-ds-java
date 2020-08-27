package datastructure;

public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount = 0;
    private Node root = null;

    private class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elm) {
            this.data = elm;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return nodeCount;
    }

    public boolean add(T elm) {
        if (contains(elm)) {
            return false;
        } else {
            root = add(root, elm);
            nodeCount++;
            return true;
        }
    }

    private Node add(Node node, T elm) {
        if (node == null) {
            node = new Node(null, null, elm);
        } else {
            if (elm.compareTo(node.data) < 0) {
                node.left = add(node.left, elm);
            } else {
                node.right = add(node.right, elm);
            }
        }

        return node;
    }

    public boolean remove(T elm) {
        if (contains(elm)) {
            root = remove(root, elm);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elm) {
        if (node == null) return null;

        int cmp = elm.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, elm);
        } else if (cmp > 0) {
            node.right = remove(node.right, elm);
        } else {
            if (node.left == null) {
                Node rightChild = node.right;
                node.data = null;
                node = null;

                return rightChild;
            } else if (node.right == null) {
                Node leftChild = node.left;
                node.data = null;
                node = null;

                return leftChild;
            } else {
                Node tmp = findMin(node.right);
                node.data = tmp.data;
                node.right = remove(node.right, tmp.data);
            }
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node findMax(Node node) {
        while (node.right != null) node = node.right;
        return node;
    }

    public boolean contains(T elm) {
        return contains(root, elm);
    }

    private boolean contains(Node node, T elm) {
        if (node == null) return false;

        int cmp = elm.compareTo(node.data);

        if (cmp < 0) return contains(node.left, elm);
        else if (cmp > 0) return contains(node.right, elm);
        else return true;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
