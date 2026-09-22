class LinkedList {
    Node head;
    Node tail;
    int size;
    private static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    public LinkedList() {}

    public int get(int index) {
        if (isOutOfBounds(index)) {
            return -1;
        }
        return findNode(index).value;
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= size;
    }

    public void insertHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        if (size == 0) {
            tail = newHead;
        }
        size++;
    }

    public void insertTail(int val) {
        if (size == 0) {
            insertHead(val);
        } else {
            Node newTail = new Node(val);
            tail.next = newTail;
            tail = newTail;
            size++;
        }
    }

    private Node findNode(int index) {
        if (index == 0) {
            return head;
        }
        if (index + 1 == size) {
            return tail;
        }

        int i = 1;
        Node currentNode = head.next;
        while (i != index) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }

    public boolean remove(int index) {
        if (isOutOfBounds(index)) {
            return false;
        }

        if (index == 0) {
            head = head.next;
        } else {
            int i = 1;
            Node currentNode = head;
            while (i != index) {
                currentNode = currentNode.next;
                i++;
            }
            currentNode.next = currentNode.next.next;

        }
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Node current = head;
        while(current != null) {
            arrayList.add(current.value);
            current = current.next;
        }
        return arrayList;
    }
}
