class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int pos=0;
        boolean odd= true; 
        if(len%2==1)
        {
            pos = len/2;
        }else{
            pos=len/2;
            odd= false;
        }
        int n =0,m=0, count=0,x=0, y=0;
        //int[] temp = new int[(len/2)+1];
        while(count<((len/2)+1)){
            if(n<nums1.length && m<nums2.length && nums1[n]<nums2[m]){
                y=x;
                x= nums1[n];
                n++;
            }else if(m<nums2.length){
                y=x;
                x= nums2[m];
                m++;
            }else{
                y=x;
                x = nums1[n];
                n++;
            }
            if(count==pos && odd){
                return (double)x;
            }else if(count==pos && !odd){
                return (double)(x+y)/2;
            }
             count++;
        }
        return -1;

    }
}