class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //We simulate merging the two sorted arrays and stop at the middle.
        //The median is either the middle element (odd) or average of two middles (even).
        int len = nums1.length + nums2.length;
        int position = len / 2;
        boolean odd = true;
        if (len % 2 == 0)
            odd = false;
        //we are keeping current num (x) and prev num(y) from the sorted series from two arrays
        // because we need both nums - prev and current to find median for even nums
        int n = 0, m = 0, count = 0, x = 0, y = 0;
        // x: current number 
        // y: previous number 
        // n: pointer for nums1 
        // m: pointer for nums2 
        while (count < ((len / 2) + 1)) {
            if (n < nums1.length && m < nums2.length && nums1[n] < nums2[m]) {
                y = x;
                // taking num from nums1
                x = nums1[n];
                n++;
            } else if (m < nums2.length) {
                y = x;
                // taking num from nums2
                x = nums2[m];
                m++;
            } else {
                // if none conditions match means only nums1 is only left , nums2 is exhausted
                y = x;
                x = nums1[n];
                n++;
            }
            if (count == position && odd) {
                return (double) x;
            } else if (count == position && !odd) {
                return (double) (x + y) / 2;
            }
            count++; 
        }
        return -1;

    }
}