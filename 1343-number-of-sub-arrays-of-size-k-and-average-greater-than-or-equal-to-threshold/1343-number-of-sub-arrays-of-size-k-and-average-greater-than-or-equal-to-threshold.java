class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] dp = new int[arr.length+1];
        int limit = threshold * k;
        int sum = 0;
        for(int i =0;i<k;i++){
            sum+=arr[i];
        }
        dp[k] = sum>=limit ? 1 :0;
        int start = 0;
        for(int i =k;i<arr.length;i++){
            sum = sum - arr[start++] + arr[i]; 
            dp[i+1] = dp[i] + (sum>=limit ? 1 : 0);
            

        } 
        return dp[arr.length];
    }
}