class Solution {
       /*
            Input: numbers = [1,2,3,4], target = 3
 i           j
[1 , 2 , 3 , 4]
i = 1, ? = 2, omit anything greater than 2

j(4) > 2, j--

 i       j 
[1 , 2 , 3 , 4]

 i       j 
[1 , 2 , 3 , 4]

j(3) > i(2), j--

 i   j       
[1 , 2 , 3 , 4]

j == i



             1 -> 3 = 2, while j > 2, moving, when we get to i, we break 
            while (j > diff) move j
            target - i = 2
        */

    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;

        if (
            length < 2 || length > 30000
            || numbers[0] < -1000 || numbers[length-1] > 1000
            || target < -1000 || target > 1000
            ) {
            return new int[0];
        }

        int i = 0;
        int j = length - 1;
        int targetValue = target - numbers[i];
        while (j > i) {
            if (targetValue == numbers[j]) {
                return new int[]{i + 1, j + 1};
            }
            if (targetValue < numbers[j]) {
                j--;
            } else {
                i++;
                targetValue = target - numbers[i];
            }
        }
        
        
        // // Iterate to get the first number
        // for (int i = 0; i < length - 1; i++) {
        //     // Inner loop to get the second number
        //     int targetDiff = target - numbers[i];
        //     for (int j = length - 1; j > i; j--) {
        //         if (numbers[j] == targetDiff) { // 1, 2
        //             return new int[]{i + 1, j + 1};
        //         }
        //     }

        // }

        return new int[0];
    }
}














