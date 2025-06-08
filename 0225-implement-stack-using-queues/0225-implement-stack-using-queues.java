class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int capacity;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        capacity = 0;
    }

    public void push(int x) {
        q1.offer(x);
        capacity++;
    }

    public int pop() {
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }
        int temp = q1.poll();
        while (q2.size() != 0) {
            q1.add(q2.poll());
        }
        return temp;
    }

    public int top() {
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }
        int temp = q1.peek();
        q2.add(q1.poll());
        while (q2.size() != 0) {
            q1.add(q2.poll());
        }
        return temp;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

// class MyStack {
//     ArrayDeque<Integer> q;
//     public MyStack() {
//         q = new ArrayDeque<>();
//     }

//     public void push(int x) {
//         q.offer(x);
//     }

//     public int pop() {

//         return q.pollLast();
//     }

//     public int top() {
//         return q.peekLast();
//     }

//     public boolean empty() {
//         return q.isEmpty();
//     }
// }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */