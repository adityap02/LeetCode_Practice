class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Recursion :  At each index, you can either add the current number or subtract it.
        // Keep track of the current sum and the index.
        return helper(nums, target, 0, 0);
    }
    //O(2^n)
    private int helper(int[] arr, int target, int idx, int sum) {
        //base case : All elements of arr are scanned
        if (idx >= arr.length)
            return sum == target ? 1 : 0;
        //either we substract 
        int subtract = helper(arr, target, idx + 1, sum - arr[idx]);
        //or we add
        int add = helper(arr, target, idx + 1, sum + arr[idx]);

        return subtract + add;
    }
}


    //DP SOlution Below O(n*m)
    // public int findTargetSumWays(int[] nums, int target) {
    // Map to store the count of ways to achieve each sum
    //     Map<Integer, Integer> counter = new HashMap<>();
    //     counter.put(0, 1);

    //     for (int n : nums) {
    //         Map<Integer, Integer> temp = new HashMap<>();
            // For each existing sum, add and subtract the current number
    //         for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
    //             int total = entry.getKey();
    //             int count = entry.getValue();

    //             temp.put(total + n, temp.getOrDefault(total + n, 0) + count);
    //             temp.put(total - n, temp.getOrDefault(total - n, 0) + count);
    //         }
     // Move to next number with updated ways
    //         counter = temp;
    //     }

    //     return counter.getOrDefault(target, 0);        
    // }

