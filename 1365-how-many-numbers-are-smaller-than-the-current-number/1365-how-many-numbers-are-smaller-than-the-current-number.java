class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int[] copiedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copiedArray);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<copiedArray.length;i++){
            if(!map.containsKey(copiedArray[i])){
                map.put(copiedArray[i],i);
            }
            
        }
        int x= 0;
        for(int n: nums){
            ans[x] = map.get(n);
            x++;
        }

        return ans;
    }
}