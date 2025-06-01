class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> a[1]<b[1]);
        //PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        // for(int[] i : trips){
        //     pq.add(i);
        // }//TC : nLogn
        TreeMap<Integer,Integer> map = new TreeMap<>(); // Key-> EndTime, Val-> capacity
        // while(!pq.isEmpty()){
            for(int i=0;i<trips.length;i++){
            //int[] temp = pq.poll();
            int[] temp = trips[i];
            
            if(!map.isEmpty()){
                while(!map.isEmpty() && map.firstEntry().getKey()<=temp[1]){
                    capacity+=map.pollFirstEntry().getValue();
                }
            }
            map.put(temp[2], map.getOrDefault(temp[2], 0)+temp[0]);
            capacity -= temp[0];
            if(capacity<0){
                return false;
            }

        }//TC : Treemap has O(log n) for insertion, we are doing it n times : O(nlogn)
        return true;
    }
}