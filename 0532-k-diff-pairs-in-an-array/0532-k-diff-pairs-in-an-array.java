class Solution {
    public int findPairs(int[] nums, int k) {
        // Set<Integer> set = new HashSet<>();
         Set<String> sols = new HashSet<>();
        // int ans = 0;
        // for(int n : nums){
        //     set.add(n);
        // }
        // Iterator<Integer> iterator = set.iterator();
        // while(iterator.hasNext()){
        //     Integer next = iterator.next();
        //       if(set.contains(Math.abs(next-k))){
        //         if(!sols.contains(Integer.toString(next) + "," + Integer.toString(next-k))){
        //           sols.add(Integer.toString(next) + "," + Integer.toString(next-k));
        //         }
        //     }
        // }
        // Arrays.sort(nums);

        // for(int i  : nums){
        //   if()
        // }
                if(nums.length==1){
          return 0;
        }
        Arrays.sort(nums);
        int l= nums.length-2 , r = nums.length-1;

        while(r>=0){
          while(l>=0){
           if(nums[l]==(nums[r]-k)){
            sols.add(Integer.toString(nums[r])+","+ Integer.toString(nums[r]-k));
            break;
           }
            l--;           

          }
          r--;
           l = r-1;
        }
      System.out.println(sols);
        return sols.size();
    }
}