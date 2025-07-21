class Solution {
    public int[][] kClosest(int[][] points, int k) {

        //Convert the formula to Comparator  and no need for square root as (x2,y2) is 0,0 
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (a.getKey() * a.getKey() + a.getValue() * a.getValue())
                        - (b.getKey() * b.getKey() + b.getValue() * b.getValue()));
        // √(x1 - x2)2 + (y1 - y2)2)
        // Math.sqrt((Math.pow(a.getKey()-b.getKey())) + (Math.pow(a.getValue()-b.getValue())))
        // Math.sqrt((Math.pow(a.getKey())) + (Math.pow(a.getValue())))
        for (int[] p : points) {
            pq.offer(new Pair(p[0], p[1]));
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> p = pq.poll();
            ans[i][0] = p.getKey();
            ans[i][1] = p.getValue();
        }
        return ans;
    }

    //For Faster / Better Answer - See Binary Search in Editorial
    // We perform a binary search on distance rather than index — in each step, we check how many points lie within a target distance from the origin. Based on whether it's fewer or more than k, we adjust our range and eliminate half the search space, leading to an average O(N) time solution.
}