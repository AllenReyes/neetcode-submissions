class HashTable {

    private Node[] table;
    private int size;

    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(int key) {
        return Math.floorMod(key, table.length);
    }

    private boolean shouldResize() {
        return (size + 1) * 2 >= table.length;
    }

    public HashTable(int capacity) {
        table = new Node[capacity];
    }

    public void insert(int key, int value) {
        if (shouldResize()) {
            resize();
        }
        int hashKey = hash(key);
        Node node = table[hashKey];

        if (node == null) {
            table[hashKey] = new Node(key, value);
            size++;
            return;
        } 

        while (true)  {
            if (key == node.key) {
                node.value = value;
                return;
            }
            if (node.next == null) {
                size++;
                node.next = new Node(key, value);
                return;
            }
            node = node.next;
        }
    }

    public int get(int key) {
        Node node = table[hash(key)];
        while(node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int hashKey = hash(key);
        Node node = table[hashKey];
        if (node == null) {
            return false;
        }

        if (node.key == key) {
            table[hashKey] = node.next;
            size--;
            return true;
        }
        
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return table.length;
    }

    public void resize() {
        int newCapacity = table.length * 2;
        Node[] oldTable = table;
        Node[] resizedTable = new Node[newCapacity];
        table = resizedTable;
        size = 0;
        for (int i = 0; i < oldTable.length; i++) {
            Node node = oldTable[i];
            while (node != null) {
                insert(node.key, node.value);
                node = node.next;
            }
        }
    }
}
