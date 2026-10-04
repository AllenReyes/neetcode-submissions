class Solution {

    /*
        Input: strs = ["Hello","World",":3Me%","0123456789"]

        Hello%World

        Hello = 5:Hello
        World = 5:World
        Me% = 5::3Me%
        0123456789 = 10:0123456789
    */
    private static final char DELIMITER = ':';

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            result.append(String.format(
                "%d%c%s",
                str.length(),
                DELIMITER,
                str));
        }
        return result.toString();
    }

    /*
        Input: "5:Hello5:World5::3Me%"
        i 
        [5,:,H,e,l,l,o,5]

        

        Output: ["Hello","World"]
    */
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        int i = 0;
        
        while (i < chars.length) {
            // Get length of string -- 10:0123456789
            StringBuilder digits = new StringBuilder();    
            while (Character.isDigit(chars[i])) {
                digits.append(chars[i]);
                i++;
            }
            int length = Integer.parseInt(digits.toString());

            // Get delimiter -- :0123456789
            char delimiter = chars[i];
            i++;

            if (delimiter != DELIMITER) {
                // TODO: Maybe throw exception
                return result;
            }

            // Form string -- 0123456789
            StringBuilder decodedString = new StringBuilder();
            // Length = 10
            while (length > 0) {
                decodedString.append(chars[i]);
                i++;
                length--;
            }

            // Add to result
            result.add(decodedString.toString());
        }

        return result;
    }
}
