public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //We sort the cars by position (desc Order by position) and calculate how long each car takes to reach the destination. If a car takes more time than the car ahead, it can’t catch up and forms a new fleet. Otherwise, it merges into the fleet in front.
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        
        int fleets = 1;
        double prevTime = (double)(target - pair[0][0]) / pair[0][1];
        //time to reach target -> (target - position ) / Speed

        for (int i = 1; i < n; i++) {
            //for remaining cars, check if current car takes more time than prevCar time 
            // Then it wont collide, so fleet++
            double currTime = (double)(target - pair[i][0]) / pair[i][1];
            if (currTime > prevTime) {
                fleets++;
                prevTime = currTime;
            }
        }
        return fleets;
    }
}