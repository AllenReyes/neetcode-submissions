class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int sizeMultiplier = 2;

        if (length < 1 || length > 1000) {
            return nums;
        }

        int[] doubleNums = new int[length * sizeMultiplier];

        
        for (int i = 0; i < length; i++) {
            // First half
            doubleNums[i] = nums[i];
            // Second half
            doubleNums[i + length] = nums[i];
        }

        return doubleNums;
    }
}