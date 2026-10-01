class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int addend = target - num;

            if (seen.containsKey(addend)) {
                int addendIndex = seen.get(addend);
                return new int[]{addendIndex, i};
            } 

            seen.put(num, i);
        }

        return new int[0];
    }
}
