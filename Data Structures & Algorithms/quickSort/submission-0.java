// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void quickSort(List<Pair> pairs, int left, int right) {
        // Base case
        if (left >= right) {
            return;
        }

        // Get the pivot index based on partitioning
        int pivotIndex = partition(pairs, left, right);

        // Recursive call for left and right from partition
        quickSort(pairs, left, pivotIndex - 1);
        quickSort(pairs, pivotIndex + 1, right);
    }

    private int partition(List<Pair> pairs, int left, int right) {
        Pair pivot = pairs.get(right);

        int i = left;

        for (int j = left; j < right; j++) {
            if (pairs.get(j).key < pivot.key) {
                swap(pairs, i, j);
                i++;
            }
        }

        swap(pairs, i, right);
        return i;
    }

    private void swap(List<Pair> pairs, int i, int j) {
        Pair temp = pairs.get(i);
        pairs.set(i, pairs.get(j));
        pairs.set(j, temp);
    }
}
