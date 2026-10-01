class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Start at end of nums1, they are sorted
        int j = n - 1; // Start at end of nums2, they are sorted
        int write = m + n - 1;

        while (i >= 0 && j >= 0) {
            // Write i value if i > j, next i
            if (nums1[i] > nums2[j]) {
                // We know this is the largest value so write
                nums1[write] = nums1[i];
                i--; // Move i to left value
            } else {
                // We know that nums2 is larger, so we write and move j left;
                nums1[write] = nums2[j];
                j--;
            }
            write--;
        }

        // We exited because either i or j or both! have ended iteration
        // If there is still i, it should already be sorted, so nothing to do.
        // If there is still j, we need to write it to the rest of write open spots blindly
        while (j >= 0) {
            nums1[write] = nums2[j];
            j--;
            write--;
        }
    }
}