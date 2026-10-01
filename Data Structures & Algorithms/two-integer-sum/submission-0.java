class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> addends = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int addend = target - num;

            if (addends.containsKey(addend)) {
                int addendIndex = addends.get(addend);
                return new int[]{addendIndex, i};
            } 

            addends.put(num, i);
        }

        return new int[0];
    }
}
