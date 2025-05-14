class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n) && n!=1){
            set.add(n);
            n = helper(n);
            
        }
        if(n==1){
            return true;
        }
        return false;
    }

    int helper(int n){
        int ans = 0;
        while(n>0){
            ans += Math.pow(n%10, 2); 
            n = n/10;
        }
        return ans;
    }
}