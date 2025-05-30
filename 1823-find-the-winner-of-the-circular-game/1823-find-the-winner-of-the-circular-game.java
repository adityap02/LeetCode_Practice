class Solution {
    public int findTheWinner(int n, int k) {
        // LinkedList<Integer> list = new LinkedList<>();
        // for(int i =1;i<=n;i++){
        //     list.addLast(i);
        // }

        // while(list.size()>1){
            
        //     for(int i=0;i<k-1;i++){
        //         //IMPORTANT 
        //         list.add(list.remove());
        //     }
        //     list.remove();
        // }
        // return list.peek();

        int ans = 0;
        for(int i =2;i<=n;i++){
            ans = (ans+k)%i;
        }

        return ans +1;


    }
}