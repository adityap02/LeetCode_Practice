public class Solution {
    //Here we will use BFS : Create Adjacency List of all words in wordList ( hot -> dot, lot, hit)
    // to do this it will take O(n^2 *m) -> not acceptable as n can be very large 
    // So we make using the words in the wordlist, as only 1 character can be changed
    // will try to check for each word in wordList if ex: hot -> *ht / h*t / ho* (* can be anything from 26 characters)
    //so will take a linkedList , add 1st word, for that word will find all possible words in wordlist 
    //by using substring of original word to match with word in Wordlist -> set of WordList for O(1) lookup 
    //This way create adjacency list and check if endword is reached 
    // O(n * m^2) , SC : O(n * m^2)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        while (!q.isEmpty()) {
            res++;
            for (int i = q.size(); i > 0; i--) {
                String node = q.poll();
                if (node.equals(endWord)) return res;
                for (int j = 0; j < node.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == node.charAt(j)) continue;
                        String nei = node.substring(0, j) + c + node.substring(j + 1);
                        if (words.contains(nei)) {
                            q.offer(nei);
                            words.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}