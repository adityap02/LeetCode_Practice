class MyCircularDeque {
    Deque<Integer> list;
    int capacity;

    public MyCircularDeque(int k) {
        list = new ArrayDeque<>();
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (list.size() < capacity) {
            list.addFirst(value);

            return true;
        } else {
            return false;
        }
    }

    public boolean insertLast(int value) {
        if (list.size() < capacity) {
            list.addLast(value);

            return true;
        } else {
            return false;
        }

    }

    public boolean deleteFront() {
        if (list.size() > 0) {
            list.removeFirst();

            return true;
        } else {
            return false;
        }
    }

    public boolean deleteLast() {
        if (list.size() > 0) {
            list.removeLast();

            return true;
        } else {
            return false;
        }
    }

    public int getFront() {
        if (list.size() == 0) {
            return -1;
        }
        return list.getFirst();
    }

    public int getRear() {
        if (list.size() == 0) {
            return -1;
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();

    }

    public boolean isFull() {
        return list.size()>=capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */