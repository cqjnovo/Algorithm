class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = nums1[0];
        boolean hasOdd = false;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < mn) {
                mn = nums1[i];
            }
            if ((nums1[i] & 1) == 1) {
                hasOdd = true;
            }
        }    
        if ((mn & 1) == 1) {
            return true;
        }
        return !hasOdd;
    }
}