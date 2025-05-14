class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sq = helper(n);
        set.add(sq);
        while(!set.contains(helper(sq)) && sq!=1){
            sq = helper(sq);
            set.add(sq);
        }
        if(sq==1){
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