class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> wordMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            wordMap
                .computeIfAbsent(sorted, key -> new ArrayList<>())
                .add(word);
        }
        List<List<String>> result = new ArrayList<>(wordMap.values());
        return result;
    }
}
