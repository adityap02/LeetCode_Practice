class Solution {
     public List<String> generateParenthesis(int n) {
//Rules for Backtracking : 
        //max #of open and close = n
        //Can only add Open IF(Open <n)
        //Can only add close IF (close<open)
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    }