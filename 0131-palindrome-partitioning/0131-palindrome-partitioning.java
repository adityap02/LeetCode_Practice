class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        //Use BackTracking
        //Make all possible partitions, checking if those partitions are palindrome
        ans = new ArrayList<>();
        //String, a list to store current partition , index = 0
        backtrack(s , new ArrayList<>(), 0);
        return ans;
    }

    void backtrack(String s, List<String> part, int i) {
        //Base Case , if index reached to len of s , All words are completed
        if (i >= s.length()) {
            ans.add(new ArrayList<>(part));
            return;
        }
        //start from next index after i to check if the substring (i, j+1) it is a palindrome?
        //if it is -> then add that to part and then backtrack into same function with the next index 
        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                part.add(s.substring(i, j + 1));
                //Backtrack here with next index
                backtrack(s, part, j+1);
                //remove the recently added String from part 
                part.remove(part.size() - 1);
            }
        }
    }
    boolean isPali(String s, int l, int r){
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}