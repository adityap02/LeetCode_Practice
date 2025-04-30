class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        if(x < arr[0]){
            for(int i =0;i<k;i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        if(x > arr[arr.length-1]){
            for(int i =arr.length-k;i<=arr.length-1;i++){
                ans.add(arr[i]);
            }
            return ans;
        }

        
        // int l= find(x, arr)-1;
        // int r = l+2;
        // ans.add(x);
        // System.out.println(l);
        // while(k>1){
        //     if(l>=0 && r<arr.length){
        //         if((arr[l]-x) < (arr[r]-x)){
        //         ans.add(arr[l]);
        //         l--;
        //         k--;
        //         }else if((arr[l]-x) == (arr[r]-x)){
        //             if(arr[l]<arr[r]){
        //                 ans.add(arr[l]);
        //                 l--;
        //                 k--;
        //             }
                   
        //         }
        //         else{
        //             ans.add(arr[r]);
        //             r++;
        //             k--;
        //         }
        //     }else if(l>=0){
        //         ans.add(arr[l]);
        //         l--;
        //         k--;
        //     }else{
        //         ans.add(arr[r]);
        //         r++;
        //         k--;
        //     }
        // }
        // Collections.sort(ans);
        // return ans;
        
        int left = 0, right = arr.length - 1;

       while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    
    }
    // public int find(int x, int[] arr){
    //     //Binary Search
    //     int l=0, r=arr.length-1;
    //     while(l<=r){
    //         int m = l+ (r-l)/2;
    //         if(arr[m]==x){
    //             return m;
    //         }else if(arr[m]<x){
    //             l=m+1;
    //         }else{
    //             r=m-1;
    //         }
    //     }
    //     return 0;
    // }
}