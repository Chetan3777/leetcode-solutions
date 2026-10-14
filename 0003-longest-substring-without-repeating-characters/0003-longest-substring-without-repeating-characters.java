class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, best = 0;
        Set<Character> window = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}