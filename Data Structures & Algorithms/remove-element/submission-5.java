class Solution {
    public int removeElement(int[] nums, int val) {
        int numsLength = nums.length;
        int currentSize = numsLength;
        int i = 0;
        
        if (numsLength == 1 && nums[i] == val) {
            nums[i] = '_';
            return 0;
        }

        while (i < currentSize) {
            if (nums[i] == val) {
                nums[i] = nums[currentSize - 1];
                currentSize -= 1;
            }
            if (nums[i] != val) {
                i += 1;
            }    
        }

        return currentSize;
    }
}