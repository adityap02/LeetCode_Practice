class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(Character c : map.keySet()){
            pq.offer(map.get(c));
        }
        int ans =0;
        while(!pq.isEmpty()){
            int window = n+1;
            int counter =0;
            List<Integer> temp = new ArrayList<>();
            while(window-->0 && !pq.isEmpty()){
                int i = pq.poll();
                if(i>1){
                    temp.add(i-1);
                }
                counter++;
            }
            for(int i : temp){
                pq.add(i);
            }
            if(pq.isEmpty()){
                ans += counter;
            }else{
                ans += n+1;
            }
 
        }
        
       

        return ans;

    }
}