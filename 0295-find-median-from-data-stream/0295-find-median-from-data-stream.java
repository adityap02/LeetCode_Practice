class MedianFinder {
    //Use 2 PQ , min and max
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    //small will store all large nums in ascending order
    //large will all small elements in descending order
    // so for median, PQ will have largest num from smaller nums(Large PQ) in case of Odd
    // and for Even Nums : small.peek() will have smallest num from larger half  and large.peek() will have.. 
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