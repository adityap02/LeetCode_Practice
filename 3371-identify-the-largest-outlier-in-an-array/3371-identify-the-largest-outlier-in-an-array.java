class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>(); // num -> frequency

        int sum = 0;
        for(int num: nums) {
            sum += num;
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int best = Integer.MIN_VALUE;
        for(int num: nums) {
            // assume sum of n - 2 = x
            // sum = x + x + outlier
            // means total sum should be equal to x, then sum of all special nos(x) + outlier
            // outlier = sum - x - x
            int outlier = sum - num - num;

            // ensure distinct indices when outlier shares same value 
            if (!count.containsKey(outlier)) {
                continue;
            }

            int frequency = count.get(outlier);

            if (outlier != num || frequency > 1) {
                //outlier != num bcoz in this cycle of for loop we are considering num as x, which cant be equal to outlier
                best = Math.max(best, outlier);
            }
        }

        return best;
    }
}