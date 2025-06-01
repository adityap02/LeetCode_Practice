class Solution {
    public int characterReplacement(String s, int k) {
        //TC : O(n)
        //SC : O(1)
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // window size - most frequent char count > k ⇒ need to shrink window
            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            int window = right - left + 1;
            maxLen = Math.max(maxLen, window);
        }

        return maxLen;
    }
}
