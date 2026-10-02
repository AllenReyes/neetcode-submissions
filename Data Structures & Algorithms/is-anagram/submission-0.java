class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // key = string value, value = count
        Map<Character,Integer> letters = new HashMap<>();

        // Add first string to map
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            letters.put(key, letters.getOrDefault(key, 0) + 1);
        }

        // Check second string against map
        for (int j = 0; j < t.length(); j++) {
            char key = t.charAt(j);
            if (letters.containsKey(key)) {
                int lettersCount = letters.get(key) - 1;
                if (lettersCount == 0) {
                    letters.remove(key);
                } else {
                    letters.replace(key, lettersCount);
                }
            } else {
                return false;
            }
        }

        return letters.isEmpty();
    }
}
