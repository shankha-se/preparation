class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        double median = 0;
        int lo = 0, hi = nums1.length;
        int totalElement = nums1.length + nums2.length;

        while(lo <= hi){
            int nums1Left = (lo + hi) / 2;
            int nums2Left = (totalElement + 1) / 2 - nums1Left;

            int al = nums1Left == nums1.length ? Integer.MAX_VALUE : nums1[nums1Left];
            int bl = nums2Left == nums2.length ? Integer.MAX_VALUE : nums2[nums2Left];
            int alm1 = nums1Left == 0 ? Integer.MIN_VALUE : nums1[nums1Left - 1];
            int blm1 = nums2Left == 0 ? Integer.MIN_VALUE : nums2[nums2Left - 1];

            if(alm1 <= bl && blm1 <= al){
                int lMax = Math.max(alm1, blm1);
                if (totalElement % 2 == 0){
                    int rMin = Math.min(al, bl);
                    median = (lMax + rMin) / 2.0;
                }
                else {
                    median = lMax;
                }
                break;
            }
            else if (alm1 > bl){
                hi = nums1Left - 1;
            }
            else if (blm1 > al){
                lo = nums1Left + 1;
            }
        }
        return median;
    }
}
