class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] a = new int[n+m];
        int idx1=0,idx2 = 0,idx = 0;
        while(idx1 < n && idx2 < m){
            if(nums1[idx1] < nums2[idx2]){
                a[idx++] = nums1[idx1++];
            }
            else{
                a[idx++] = nums2[idx2++];
            }
        }
        while(idx1<n) a[idx++] = nums1[idx1++];
        while(idx2<m) a[idx++] = nums2[idx2++];
        
        if((n+m) % 2 != 0) return (double)(a[(n+m)/2]);
        return ((double)a[(n+m)/2] + (double)a[(n+m)/2-1])/2.0;
    }
}