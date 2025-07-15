class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase()) ;
    }
}
//Two Pointer Approach
// class Solution {
//     public boolean isPalindrome(String s) {
//         for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//             while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
//                 i++;
//             }
//             while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
//                 j--;
//             }

//             if (
//                 Character.toLowerCase(s.charAt(i)) !=
//                 Character.toLowerCase(s.charAt(j))
//             ) return false;
//         }

//         return true;
//     }
// }