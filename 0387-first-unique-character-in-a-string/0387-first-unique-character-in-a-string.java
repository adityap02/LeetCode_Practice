class Solution {
    public int firstUniqChar(String s) {
        // char[] ch = s.toCharArray();
        // Deque<Character> deque =new ArrayDeque<>();
        // Set<Character> set = new HashSet<>();
        // for(char c : ch){
        //     if(set.add(c)){
        //         deque.addLast(c);
        //     }else{
        //         deque.remove(c);
        //     }
        // }
        // int i=0;
        // if(!deque.isEmpty()){
        // for(char c : ch){
        //     if(c==deque.getFirst()){
        //         return i;
        //     }
        //     i++;
        // }
        // }

        //2nd  Approach
    //     char[] ch = s.toCharArray();
    //     int l=0, r=1;
    //     if(ch.length==1){
    //         return 0;
    //     }
    //     HashMap<Character,Integer>map=new HashMap<>();
    //     for(char c:ch){
    //     map.put(c,map.getOrDefault(c,0)+1);
    //   }
    //     for (int i = 0; i < ch.length; i++) {
    //         if (map.get(ch[i]) == 1) {
    //             return i;
    //         }
    //     }
    //     return -1;
        
    // }

    //Fastest 

        int[] frequency = new int[26]; 

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++; // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i; // Return the index of the first unique character
            }
        }
        // If no unique character is found, return -1
        return -1;
    }
}
