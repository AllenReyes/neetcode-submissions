// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        int size = pairs.size();
        if (size <= 1) {
            return pairs;
        }
        // Get Mid
        int mid = size / 2;

        // Left
        List<Pair> left = mergeSort(pairs.subList(0, mid));

        // Right
        List<Pair> right = mergeSort(pairs.subList(mid, size));

        return merge(left, right);
    }

    private List<Pair> merge(List<Pair> left, List<Pair> right) {
        List<Pair> result = new ArrayList<>();

        // Starting indices
        int i = 0, j = 0;

        // While left and right have values
        while (i < left.size() && j < right.size()) {
            if (left.get(i).key <= right.get(j).key) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Left only
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        // Right only
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
