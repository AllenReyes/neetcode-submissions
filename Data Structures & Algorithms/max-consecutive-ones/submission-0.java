class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        // Array Size
        int arraySize = nums.length;

        if (arraySize > 100000) {
            return -1;
        }

        // Iterate through entire array
        for (int i = 0; i < arraySize; i++) {
            if (nums[i] == 1) {
                currentCount += 1;
                maxCount = currentCount > maxCount ? currentCount : maxCount;
            } else {
                currentCount = 0;
            }
        }
        // 6
        // 0 = 1 - 0 - 1
        // 1 = 1 - 0 - 2
        // 2 = 0 - 2 - 0
        // 3 = 1 - 2 - 1
        // 4 = 1 - 2 - 2
        // 5 = 1 - 2 - 3
        return maxCount;
    }
}