// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int[] freq = new int[26];
//         //Map<Character,Integer> map = new HashMap<>();
//         for(char c : s1.toCharArray()){
//            freq[c-'a']++;
//         }
//         int[] freq1 = new int[26];
//         for(char c : s2.toCharArray()){
//            freq1[c-'a']++;
//         }
//         int matches = 0;
//         for(int i=0;i<26;i++){
//             if(freq[i] ==freq1[i]){
//                 matches++;
//             }
//         }
//         int l=0;
//         for(int i=0;i<s2.length()-s1.length();i++){
//             if(matches==26){
//                 return true;
//             }
//             int index = s2.charAt(i) - 'a';
//             freq1[index]++;
//             if(freq[index] == freq1[index]){
//                 matches++;
//             }else if(freq[index]+1 == freq1[index]){
//                 matches--;
//             }

//             index = s2.charAt(l) - 'a';
//             freq1[index]--;
//             if(freq[index] == freq1[index]){
//                 matches++;
//             }else if(freq[index]-1 == freq1[index]){
//                 matches--;
//             }
//             l++;
//         }
//         return matches==26;

//     }
// }

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count the frequency of characters in s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }
        // Slide the window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches == 26) {
                return true;
            }
            // if (matches(s1Count, s2Count))
            //     return true;
            // Update the window
            // Removing the leftmost character of the previous window
            int index = s2.charAt(i) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;//after decreasing, it matched
            } else if (s1Count[index] == s2Count[index] + 1) {
                matches--;//it matched before decrementing
            }

            // Adding the rightmost character of the new window
            int rIndex = s2.charAt(i + s1.length()) - 'a';
            if (s1Count[rIndex] == s2Count[rIndex])
                matches--;
            s2Count[rIndex]++;
            if (s1Count[rIndex] == s2Count[rIndex])
                matches++;
        }
        // Check the last window
        return matches == 26;

    }

    // private boolean matches(int[] s1Count, int[] s2Count) {
    //     for (int i = 0; i < 26; i++) {
    //         if (s1Count[i] != s2Count[i])
    //             return false;
    //     }
    //     return true;
    // }
}