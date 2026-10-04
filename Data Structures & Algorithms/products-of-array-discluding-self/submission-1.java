class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] prefix = new int[length];
        int[] postfix = new int[length];
        
        prefix[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }

        postfix[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i];
        }

        for (int i = 0; i < length; i++) {
            int prefixValue = 1;
            if (i > 0) {
                prefixValue = prefix[i-1];
            }
            int postfixValue = 1;
            if (i < length - 1) {
                postfixValue = postfix[i+1];
            }
            result[i] = prefixValue * postfixValue;
        }

        return result;
    }
}  
