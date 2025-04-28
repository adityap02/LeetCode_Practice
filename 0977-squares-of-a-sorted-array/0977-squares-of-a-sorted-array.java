class Solution {
    public int[] sortedSquares(int[] nums) {
        // ArrayDeque<Integer> q= new ArrayDeque<>();
        // q.addFirst([nums[0]*nums[0]);
        // for(int i=1; i< nums.length-1; i++){
        //     int t = nums[i]* nums[i];
        //     if(q.getFirst()>t){
        //         q.addFirst(t);
        //     }else if(q.getLast()>t){
        //         q.addLast(t);
        //     }
        // }
        if(nums.length==1){
            return new int[] {nums[0]*nums[0]};
        }
        int i=0;
        Stack<Integer> s = new Stack<>();
        while(i< nums.length && nums[i]<0){
            s.push(Math.abs(nums[i]));
            i++;
        }
        int[] ans = new int[nums.length];
        
        for(int j=0;j<ans.length;j++){
            if(s.isEmpty() || (i<nums.length && nums[i]<s.peek())){
                ans[j] = nums[i]*nums[i];
                i++;
            }else{
                int temp = s.pop();
                ans[j]= temp* temp;
            }
        }
    return ans;
    }
}