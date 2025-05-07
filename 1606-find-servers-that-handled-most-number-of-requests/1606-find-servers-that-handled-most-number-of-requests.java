class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

            int[] busy = new int[k];
            int[] servers = new int[k];
            int max = 0;
            List<Integer> ans = new ArrayList<>();

            for(int i=0; i < arrival.length;i++){
                if(servers[i%k] <=arrival[i]){
                    //this means server is available
                    servers[i%k] = arrival[i] + load[i];
                    busy[i%k]++;
                    max= Math.max(max,busy[i%k]);
                }else{
                    int t = i%k;
                    for (int j =1 ; j<=k ;j++){
                        int pos = (t+j)%k;
                        if(servers[pos]<=arrival[i]){
                            servers[pos] = arrival[i] + load[i];
                            busy[pos]++;
                            max= Math.max(max,busy[pos]);
                            break;
                        }
                    }
                }
            }
            for(int i=0;i<k;i++){
                if(busy[i]==max){
                    ans.add(i);
                }

            }
            return ans;
        
    }
}