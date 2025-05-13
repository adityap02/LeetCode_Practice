class MedianFinder {
private PriorityQueue<Integer> small;
private PriorityQueue<Integer> large;
private boolean even = true;
    public MedianFinder() {
        large = new PriorityQueue<>(Collections.reverseOrder());
        small = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
         if (even) {
        small.offer(num);
        large.offer(small.poll());
    } else {
        large.offer(num);
        small.offer(large.poll());
    }
    even = !even;
    }
    
    public double findMedian() {
        if (even)
        return (large.peek() + small.peek()) / 2.0;
    else
        return large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */