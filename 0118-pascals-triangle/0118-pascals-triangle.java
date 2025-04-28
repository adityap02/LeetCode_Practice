class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();  
        for(int i =1; i<=numRows;i++){
            ans.add(helper(i,ans));
        }
        return ans;
    }
    public List<Integer> helper(int i, List<List<Integer>> list){
        if(i==1){
            return new ArrayList<>(Arrays.asList(1));
        }if(i==2){
            return new ArrayList<>(Arrays.asList(1,1));
        }
        List<Integer> r = new ArrayList<>();
        r.add(1);
        for(int j=0; j<i-2;j++ ){
            List<Integer> temp = list.get(i-2);
            r.add(temp.get(j)+temp.get(j+1));
        }
        r.add(1);
        return r;
    } 
    
}