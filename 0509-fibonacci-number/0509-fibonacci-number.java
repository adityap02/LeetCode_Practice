class Solution {
    public int fib(int n) {
        // if(n==1 || n==0){
        //     return n;
        // }




        // Map<Integer,Integer> m = new HashMap<>();
        // if(m.containsKey(n))
        // {
        //     return m.get(n);
        // }
        // int a =fib(n-1);
        // int b = fib(n-2);
        // m.put(n-1,a);
        // m.put(n-2,b);
        // return a+b;
        // if(n<0){
        //     return 0;
        // }
        // return fib(n-1)+fib(n-2);
    

    //Another Mehtod Without DP (Simple but Fast)
    
    // if(n<=1){
    //     return n;
    // }
    // int a=0,b=1;
    // for(int i=2; i<=n;i++){
    //     int temp = b;
    //     b = a+b;
    //     a= temp;
    // }

    // return b;

       

       //Using HashMaps
        if(n<=1){
            return n ;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        for(int i =2;i<=n;i++){
            map.put(i, map.get(i-1)+map.get(i-2));
        }
        return map.get(n);

    }
}