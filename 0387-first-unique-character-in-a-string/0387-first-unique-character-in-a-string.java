class Solution {
    public int firstUniqChar(String s) {
        int ans = 0;
        char[] ch = s.toCharArray();
        Deque<Character> deque =new ArrayDeque<>();
        Set<Character> set = new HashSet<>();
        for(char c : ch){
            if(set.add(c)){
                deque.addLast(c);
            }else{
                deque.remove(c);
            }
        }
        int i=0;
        if(!deque.isEmpty()){
        for(char c : ch){
            if(c==deque.getFirst()){
                return i;
            }
            i++;
        }
        }

        return -1;
        
    }
}