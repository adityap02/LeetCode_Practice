class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //int min = 0;
        //List<int[]> ans = new ArrayList<>();
        LinkedList<int[]> ans = new LinkedList<>();
        int i=0;
        while(i<intervals.length){
            if(intervals[i][1] < newInterval[0]){
                ans.add(intervals[i]);
            }else{
                while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
                }
                
                break;
                // if(ans.getLast()[1]<newInterval[0]){
                //     ans.add(newInterval);


                // }else{
                //     ans.getLast()[1] = Math.max(newInterval[1], ans.getLast()[1]);
                // }
                // while(i<intervals.length-1 && ans.getLast()[1]>intervals[i][0]){
                //         ans.getLast()[1] = Math.max(ans.getLast()[1], intervals[i][1]);
                //         i++;
                // }
                // break;

            }
            i++;
        }
        ans.add(newInterval);
        while(i<intervals.length){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}