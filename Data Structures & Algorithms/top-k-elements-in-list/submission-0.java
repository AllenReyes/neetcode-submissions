class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }

        int[] result = new int[k];
        int count = k;
        /*
            1. Get counts: Get counts by hashmap, key = number, value = count
            HashMap<Integer, Integer>
            1:1,
            2:2,
            3:3
        */
        Map<Integer,Integer> numCountMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int value = numCountMap.getOrDefault(key, 0);
            numCountMap.put(key, value + 1);
        }

        /*
            2. Organize num/counts: Add to bucket sort array, where the length is the size of nums
            List<Integer>[nums.length], index = count, value = num
        */
        List<Integer>[] countBuckets = new ArrayList[nums.length + 1];
        
        for ( int key : numCountMap.keySet()) {
            int numCount = numCountMap.get(key);
            
            if (countBuckets[numCount] == null) {
                countBuckets[numCount] = new ArrayList();
            }

            countBuckets[numCount].add(key);
        }

        /*
            3. Get k values: Go through bucket and pop values.
            For loop starting from end of bucket
                Check if list not null
                Loop through list, 
                    If found
                        Deduct from k for each one found
                        Push to result array
        */
        for (int i = countBuckets.length - 1; i > 0; i--) {
            List<Integer> countList = countBuckets[i];

            if (countList != null) {
                for (int num : countList) {
                    result[count - 1] = num;
                    count--;
                }
            }

            if (count == 0) {
                return result;
            }
        }

        // Return result // Less than k found
        return result;
    }
}
