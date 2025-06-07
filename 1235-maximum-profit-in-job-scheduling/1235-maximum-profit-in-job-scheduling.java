class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();

        for(int i =0;i<profit.length;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(startTime[i]);
            temp.add(endTime[i]);
            temp.add(profit[i]);

            jobs.add(temp);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));
        return helper(jobs);
    }

    int helper(List<List<Integer>> jobs){
        int max = 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> a.get(0) -b.get(0));
        for(int i =0;i<jobs.size();i++){
            int start = jobs.get(i).get(0);
            int end = jobs.get(i).get(1);
            int profit = jobs.get(i).get(2);

            while(!pq.isEmpty() && start>= pq.peek().get(0)){
                max = Math.max(max,pq.peek().get(1));
                pq.poll();
            }
            //Bundle end & profit
            List<Integer> temp = new ArrayList<>();
            temp.add(end);
            temp.add(max+profit);

            pq.offer(temp);
        }

        
            while(!pq.isEmpty()){
                max = Math.max(max,pq.peek().get(1));
                pq.poll();
            }
        
        return max ;
    }
}