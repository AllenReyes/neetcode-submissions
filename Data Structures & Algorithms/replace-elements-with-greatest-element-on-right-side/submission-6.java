class Solution {
    public int[] replaceElements(int[] arr) {
        int lastIndex = arr.length - 1;
        int maxValue = -1;

        for (int i = lastIndex; i >= 0; i--) {
            int newMax = arr[i] > maxValue ? arr[i] : maxValue;
            arr[i] = maxValue;
            maxValue = newMax;
        }
        return arr;
    }
}