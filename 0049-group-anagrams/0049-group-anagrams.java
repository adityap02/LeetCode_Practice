class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(); 
        for(String s : strs){
            char[] ar = s.toCharArray();
            Arrays.sort(ar);
            String temp = String.valueOf(ar);
            List<String> st = map.getOrDefault(temp,new ArrayList<>());
            st.add(s);
            map.put(temp,st);
        }
        return new ArrayList(map.values());
        // Map<String,List<String>> m = new HashMap<>();

        // for(String s : strs){
        //     int[] arr = new int[26];
        //     for(char  c : s.toCharArray()){
        //         arr[(int)c-(int)'a']++;
        //     }
        //     String sss = Arrays.toString(arr);
        //     addtohashmap(m,sss,s);
        // }
        // List<List<String>> ans = new ArrayList<>(m.values());
        // return ans;
    }
    // private void addtohashmap(Map<String,List<String>> map,String key ,String val){
    //     if(map!=null && map.containsKey(key)){
    //         List<String> temp = map.get(key);
    //         temp.add(val);
    //         map.put(key,temp);
    //     }
    //     else{
    //         List<String> temp = new ArrayList<>();
    //         temp.add(val);
    //         assert map != null;
    //         map.put(key,temp);
    //     }

    // }
}