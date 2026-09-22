class Solution {
    public int[] replaceElements(int[] arr) {
        int lastIndex = arr.length - 1;
        int maxValue = arr[lastIndex];

        for (int i = lastIndex; i >= 0; i--) {
            if (arr[i] <= maxValue) { 
                arr[i] = maxValue;
            }
            if (arr[i] > maxValue) {
                int prevMax = maxValue;
                maxValue = arr[i];
                arr[i] = prevMax;
            }
        }
        arr[lastIndex] = -1;
        return arr;
    }
}