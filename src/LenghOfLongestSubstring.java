import java.util.HashMap;

public class LenghOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndex.containsKey(c)) {
                startIndex = Math.max(startIndex, charIndex.get(c) + 1);
            }
            charIndex.put(c, i);
            maxLength = Math.max(maxLength, i - startIndex + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
         int length = lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }

}
