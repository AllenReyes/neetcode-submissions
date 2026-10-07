class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        // [-1,0,1,2,-1,-4] -> [-4,-1,-1,0,1,2]
        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++) {

            // Since array is sorted, nothing after this can sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate starting values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;//j        k
            while (j < k) { // [-1,-1,0,1,2]
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> group = new ArrayList<>();
                    group.add(nums[i]);
                    group.add(nums[j]);
                    group.add(nums[k]);
                    result.add(group);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return result;
    }
}
/*
 i            j
[-1,0,1,2,-1,-4]

1. Sort
[-4,-1,-1,0,1,2]

-(-4+2) = target = -(-2) = 2 = target

0 = i + target + j

0 = (i + j) + target
-(i + j) = target

-(-1 + -4)) = -(-5) = 5 = target
*/