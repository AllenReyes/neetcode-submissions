class Deque {
    private static final int EMPTY_QUEUE_VALUE = -1;
    private class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    Node head;
    Node tail;
    int size;

    public Deque() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
       if (size == 0) {
        tail = new Node(value);
        head = tail;
       } else {
        Node newTail = new Node(value);
        tail.next = newTail;
        newTail.prev = tail;
        tail = newTail;
       }
       size++;
    }

    public void appendleft(int value) {
       if (size == 0) {
        head = new Node(value);
        tail = head;
       } else {
        Node newHead = new Node(value);
        head.prev = newHead;
        newHead.next = head;
        head = newHead;
       }
       size++;
    }
    public int pop() {
        if (size == 0) {
            return EMPTY_QUEUE_VALUE;
        }
        int value = tail.value;
        if (size == 1) {
           head = null;
           tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return value;
    }

    public int popleft() {
        if (size == 0) {
            return EMPTY_QUEUE_VALUE;
        }
        int value = head.value;
        if (size == 1) {
           head = null;
           tail = null; 
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return value;
    }
}
