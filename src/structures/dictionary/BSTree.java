package structures.dictionary;


import structures.stack.ArrayStack;

public class BSTree<K extends Comparable, V> implements Dictionary<K, V> {

    /**
     * root of a tree
     */
    private TreeNode<K, V> root;

    private int size;

    public BSTree() {

    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        return get(root, key);
    }

    private V remove(TreeNode<K, V> rmNode) {
        V val = rmNode.getValue();
        if (rmNode.getLeft() == null) {
            //remove with rigth child
            replaceSubTree(rmNode, rmNode.getRight());
        } else if (rmNode.getRight() == null) {
            //remove with left child child
            replaceSubTree(rmNode, rmNode.getLeft());
        } else {
            //remove with 2 child
            TreeNode<K, V> newSubRoot = rmNode.getRight().getMinimum();
            remove(newSubRoot);
            newSubRoot.setLeft(rmNode.getLeft());
            newSubRoot.setRight(rmNode.getRight());
            replaceSubTree(rmNode, newSubRoot);
        }
        return val;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        TreeNode<K, V> curr = root;
        int status;
        while (curr != null) {
            status = curr.getKey().compareTo(key);
            if (status > 0) {
                curr = curr.getLeft();
            } else if (status < 0) {
                curr = curr.getRight();
            } else {
                //find node
                size--;
                return remove(curr);
            }
        }
        return null;
    }

    private void replaceSubTree(TreeNode<K, V> u, TreeNode<K, V> v) {
        if (u == root) {
            root = v;
        } else {
            TreeNode<K, V> par = u.getParent();
            if (par.isLeftChild(u)) {
                par.setLeft(v);
            } else {
                par.setRight(v);
            }
        }
        u.setParent(null);
    }

    /**
     * Returns true if this dictionary contains no key-value mappings
     *
     * @return true if this dictionary contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public V put(K key, V val) {
        if (val == null || key == null) return null;
        V oldVal = get(root, key);
        root = put(root, key, val);
        return oldVal;
    }

    private TreeNode<K, V> put(TreeNode<K, V> parent, K key, V val) {
        if (parent == null) {
            //increase tree
            size++;
            TreeNode<K, V> newNode = new TreeNode<K, V>(key, val);
            return newNode;
        }
        int cmp = parent.getKey().compareTo(key);
        if (cmp == 0) {
            parent.setValue(val); //set value, don't increase tree
        } else if (cmp > 0) {
            parent.setLeft(put(parent.getLeft(), key, val));
        } else {
            parent.setRight(put(parent.getRight(), key, val));

        }
        return parent;
    }

    private V get(TreeNode<K, V> parent, K key) {
        if (parent == null) return null;
        int cmp = parent.getKey().compareTo(key);
        if (cmp < 0) {
            return get(parent.getRight(), key);
        } else if (cmp > 0) {
            return get(parent.getLeft(), key);
        } else {
            return parent.getValue();
        }
    }

    private void print_preorder(TreeNode<K, V> node) {
        if (node != null) {
            print_preorder(node.getLeft());
            print_preorder(node.getRight());
            System.out.print(node + ", ");
        }
    }

    private void print_postorder(TreeNode<K, V> node) {
        if (node != null) {
            print_preorder(node.getLeft());
            print_preorder(node.getRight());
            System.out.print(node + ", ");
        }
    }

    private void print_inorder(TreeNode<K, V> node) {
        if (node != null) {
            print_preorder(node.getLeft());
            System.out.print(node + ", ");
            print_preorder(node.getRight());
        }
    }

    private void print_levelorder(TreeNode<K, V> node) {
        ArrayStack<TreeNode<K, V>> stack = new ArrayStack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print("{" + node + "}, ");
            stack.push(node.getRight());
            stack.push(node.getLeft());
        }
    }

    @Override
    public void printDictionary(int order) {
        System.out.println("Tree: size " + size);
        switch (order) {
            case Dictionary.INORDER:
                print_inorder(root);
                break;
            case Dictionary.POSTORDER:
                print_postorder(root);
                break;
            case Dictionary.PREORDER:
                print_preorder(root);
                break;
            case Dictionary.LEVELORDER:
            default:
                print_levelorder(root);
                break;
        }
    }

}

class TreeNode<K extends Comparable, V> {
    private V value;
    private K key;
    /**
     * reference to the right node
     */
    private TreeNode<K, V> right;

    /**
     * reference to the left node
     */
    private TreeNode<K, V> left;
    /**
     * reference to the parent node
     */

    private TreeNode<K, V> parent;

    public TreeNode(K key, V e) {
        value = e;
        this.key = key;
    }

    public TreeNode(K key, V val, TreeNode<K, V> parent) {
        this(key, val);
        this.parent = parent;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public TreeNode<K, V> addLeftChild(K key, V val) {
        TreeNode<K, V> node = new TreeNode<K, V>(key, val, this);
        setLeft(node);
        return node;
    }

    public TreeNode<K, V> addRightChild(K key, V val) {
        TreeNode<K, V> node = new TreeNode<K, V>(key, val, this);
        setRight(node);
        return node;
    }

    public void setLeft(TreeNode<K, V> left) {
        if (this.left != null) {
            this.left.parent = null;
        }
        this.left = left;
        if (this.left != null) {
            this.left.parent = this;
        }
    }

    public void setRight(TreeNode<K, V> right) {
        if (this.right != null) {
            this.right.parent = null;
        }
        this.right = right;
        if (this.right != null) {
            this.right.parent = this;
        }
    }

    public boolean isLeftChild(TreeNode<K, V> node) {
        return left == node && node != null;
    }

    public boolean isRightChild(TreeNode<K, V> node) {
        return node != null && node == right;
    }

    public TreeNode<K, V> getMinimum() {
        if (left != null) {
            return left.getMinimum();
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return "[" + key + "] : " + value;
    }

    public TreeNode<K, V> getRight() {
        return right;
    }

    public TreeNode<K, V> getLeft() {
        return left;
    }


    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public TreeNode<K, V> getParent() {
        return parent;
    }

    public void setParent(TreeNode<K, V> parent) {
        this.parent = parent;
    }
}

