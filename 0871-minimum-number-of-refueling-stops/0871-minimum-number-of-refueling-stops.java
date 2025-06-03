class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //int[][] stations -> [position,Fuel]
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        // This will store the fuel from pumps in reverse order and we will check that if our car can 
        //reach till that maxFuel pump without breaking... bcoz we need to find Min num of stops...
        // if it can reach we will use that pump with higest fuel, if not we will remove that from the PQ
        int ans = 0;
        int position = 0;

        for (int[] station : stations) {
            int pumpPos = station[0];
            int fuel = station[1];
            startFuel -= pumpPos - position;
            while (!pq.isEmpty() && startFuel < 0) { 
                // must refuel in past
                startFuel += pq.poll();
                ans++;
            }

            if (startFuel < 0)
                return -1;
            pq.offer(fuel);
            position = pumpPos;
        }

        // Repeat body for station = (target, inf)
        {
            startFuel -= target - position;
            while (!pq.isEmpty() && startFuel < 0) {
                startFuel += pq.poll();
                ans++;
            }
            if (startFuel< 0) return -1;
        }
        return ans;

    }
}