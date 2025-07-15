class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // for(int i =0;i<numbers.length;i++){
        //     int idx = i+1;
        //     while(idx < numbers.length && (numbers[idx]+ numbers[i] <target)){
        //         idx++;
        //     }
        //     if(idx < numbers.length && numbers[idx]+ numbers[i] == target){
        //         return new int[] {i+1,idx+1};
        //     }
        // }
        // return new int[] {-1,-1};

        //Two Pointer

        int l=0, r= numbers.length-1, sum =0;

        while(l!=r){
            sum=numbers[l]+numbers[r];
            if(sum>target){
                r--;
            }else if(sum <target){
                l++;
            }else{
                return new int[] {l+1,r+1};
            }
        }
        return new int[] {-1,-1};
    }
}