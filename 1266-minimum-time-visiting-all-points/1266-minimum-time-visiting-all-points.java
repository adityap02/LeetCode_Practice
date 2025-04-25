class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if(points.length==1){
            return 0;
        }
        int x1=points[0][0], y1=points[0][1], d=0;

        for(int i=1; i<points.length; i++){
            int x2= points[i][0];
            int y2 = points[i][1];
            d+=Math.max(Math.abs(y2-y1),Math.abs(x2-x1));
            x1=x2;
            y1=y2;

        }
        return d;
    }
}