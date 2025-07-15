class Solution {

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        boolean consonant = false, vovel = false;
        for (Character c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if ((!vovel || !consonant) && Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (set.contains(ch)) {
                    vovel = true;
                } else {
                    consonant = true;
                }
            }
        }
        return vovel && consonant;
    }
}