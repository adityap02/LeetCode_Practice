class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    // Map<String,Boolean> map = new HashMap<>();
    // return rec(map,sx,sy,tx,ty);
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);

    }

    // public boolean rec(Map<String,Boolean> map , int sx, int sy, int tx, int ty){
    //     if(map.containsKey(Integer.valueOf(sx).toString()+","+(Integer.valueOf(sy).toString()))){
    //         return map.get(Integer.valueOf(sx).toString()+","+(Integer.valueOf(sy).toString()));
    //     }
    //      boolean ans1,ans2;
    //     if(sx<0 || sy<0 || tx<0 || ty<0){
    //         map.put(Integer.valueOf(sx).toString()+","+(Integer.valueOf(sy).toString()),false);
    //         return false;
    //     }
    //     if(sx>tx || sy>ty){
    //         map.put(Integer.valueOf(sx).toString()+","+(Integer.valueOf(sy).toString()),false);
    //         return false;
    //     }
    //     if(sx==tx && sy==ty){
    //         map.put(Integer.valueOf(sx).toString()+","+(Integer.valueOf(sy).toString()),true);
    //         return true;
    //     }else{ 
    //         ans1= rec(map,sx,sy+sx,tx,ty);
    //         ans2= rec(map,sx+sy,sy,tx,ty);
    //     }
    //     return ans1 || ans2;
    // }

}