class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26)
            return false;
        Set<Character> set = new HashSet<>();
        for (Character c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;

        // for (char ch = 'a'; ch <= 'z'; ch++) {
        //     if (sentence.indexOf(ch) < 0) {
        //         return false;
        //     }
        // }
        // return true;
    }
}