class Solution {
    public boolean isPalindrome(int x) {
        /*
         * 111 -> [1] [1] [1]
         * 123 -> [1] [2] [3]
         * 123123 -> [3] <- i = start of list, i++
         * 12312 -> [2] <- 
         * 1231 -> [1]
         * ..... j >= i return true
         * 123 -> [3]
         * 12 -> [2] <- 
         * 1 -> [1] <- j = end of list (length - 1), j--
         * 0 -> 0123456 
         */
        if (x < 0) return false;
        
        List<Integer> digits = new ArrayList<>();

        while (x > 0) {
            // 123
            // Store 1s value from x -> 3
            digits.add(x % 10); // Ones value
            // Move to the next decimal placement, 123 -> 12
            x = x / 10; // 123 -> 12, division by integer will default to rounding down
        }

        int i = 0;
        int j = digits.size() - 1;

        while (i < j) {
            if (digits.get(i) != digits.get(j)) 
                return false;
            i++;
            j--;
        }

        return true;
    }
}