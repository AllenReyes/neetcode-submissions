class TreeMap {
    private class TreeNode {
        int key, value;
        TreeNode left, right;

        TreeNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    TreeNode root;

    public void insert(int key, int val) {
        root = insert(root, key, val);
    }

    private TreeNode insert(TreeNode node, int key, int value) {
        // Base case
        if (node == null) {
            return new TreeNode(key, value);
        }

        if (key < node.key) {
            node.left = insert(node.left, key, value);
        } else if (key > node.key) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    public int get(int key) {
        TreeNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.value;
            }
        }

        return -1;
    }

    public int getMin() {
        if (root == null) {
            return -1;
        }
        return getMinNode(root).value;
    }

    private TreeNode getMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        if (root == null) {
            return -1;
        }
        return getMaxNode(root).value;
    }

    private TreeNode getMaxNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private TreeNode remove(TreeNode node, int key) {
        if (node == null) {
            return null;
        }

        // Check if we have to go left or right or if we found the key
        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            // We have found the key to delete
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // At this point we know both children exist, we get the min value
            // of the right child and overwrite ("delete") the node with that value.
            // then we delete that min value from the tree, since it just bubbled up.
            TreeNode successor = getMinNode(node.right);
            node.key = successor.key;
            node.value = successor.value;
            // Delete the min key from the right node;
            node.right = remove(node.right, successor.key);
        }
        return node;
    }


    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<>();
        getInorderKeys(root, list);
        return list;
    }

    private static void getInorderKeys(TreeNode node, List<Integer> list) {
        if (node == null) return;
        getInorderKeys(node.left, list);
        list.add(node.key);
        getInorderKeys(node.right, list);
    }
}
