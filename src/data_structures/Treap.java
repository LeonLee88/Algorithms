package data_structures;

/**
 * Created by leon on 7/6/17.
 */
public class Treap {

    TreapNode root;

    public TreapNode insert(TreapNode root, int key) {
        if (root == null) {
            return new TreapNode(key);
        }
        if (root.key > key) {
            root.left = insert(root.left, key);
            // Maintain heap property if it's violated
            if (root.priority > root.left.priority) {
                root = rightRotate(root);
            }
        } else {
            root.right = insert(root.right, key);
            // Maintain heap property if it's violated
            if (root.priority > root.right.priority) {
                root = leftRotate(root);
            }
        }
        return root;
    }

    public TreapNode delete(TreapNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.key > key) {
            root.left = delete(root.left, key);
        } else if (root.key < key) {
            root.right = delete(root.right, key);
        } else if (root.left == null) {
            // left child is null
            return root.right;
        } else if (root.right == null) {
            // right child is null
            return root.left;
        } else if (root.left.priority > root.right.priority) {
            // both left and right child are not null and right child has higher priority
            root = leftRotate(root);
            root.left = delete(root.left, key);
        } else {
            // both left and right child are not null and left child has higher priority
            root = rightRotate(root);
            root.right = delete(root.right, key);
        }
        return root;
    }

    public TreapNode find(TreapNode root, int key) {
        if (this.root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }

    public TreapNode leftRotate(TreapNode node) {
        TreapNode newLeft = node;
        TreapNode newRoot = node.right;
        newLeft.right = newRoot.left;
        newRoot.left = newLeft;
        return newRoot;
    }

    public TreapNode rightRotate(TreapNode node) {
        TreapNode newRight = node;
        TreapNode newRoot = node.left;
        newRight.left = newRoot.right;
        newRoot.right = newRight;
        return newRoot;
    }
}
