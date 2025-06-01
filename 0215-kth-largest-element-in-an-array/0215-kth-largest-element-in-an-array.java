class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> p =new PriorityQueue<>(Collections.reverseOrder());
        // for(int n:nums)
        // {
        //     p.add(n);
        // }
        // int ans=0;
        // for(int i=0;i<k;i++)
        // {
        //     ans=p.poll();
        // }
        // return ans;

        Arrays.sort(nums);
        return nums[nums.length-k];

        //We can also use a modification of QuickSort here
        // randomly select a pivot , make 3 list (left,right,mid)
        //mid contains elements equal to pivot, left nums greater than the pivot and right less than pivot
        //this means now left part is the most greatest nums of whole Arrays
        //repeat the above with left array again (in recursion) 

        // List<Integer> list = new ArrayList<>();
        // for (int num: nums) {
        //     list.add(num);
        // }
        // return quickSelect(list, k);
    }
    // public int quickSelect(List<Integer> nums, int k) {
    //     int pivotIndex = new Random().nextInt(nums.size());
    //     int pivot = nums.get(pivotIndex);
        
    //     List<Integer> left = new ArrayList<>();
    //     List<Integer> mid = new ArrayList<>();
    //     List<Integer> right = new ArrayList<>();
        
    //     for (int num: nums) {
    //         if (num > pivot) {
    //             left.add(num);
    //         } else if (num < pivot) {
    //             right.add(num);
    //         } else {
    //             mid.add(num);
    //         }
    //     }
        
    //     if (k <= left.size()) {
    //         return quickSelect(left, k);
    //     }
        
    //     if (left.size() + mid.size() < k) {
    //         return quickSelect(right, k - left.size() - mid.size());
    //     }
        
    //     return pivot;
    // }
}