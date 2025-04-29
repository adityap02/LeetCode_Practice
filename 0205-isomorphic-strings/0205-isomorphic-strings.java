class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int i=0;
        while(i<sc.length){
            if(map.containsKey(sc[i]) && map.get(sc[i])!=tc[i]){
                return false;
            }else if(map.containsKey(sc[i]) && map.get(sc[i])==tc[i]){
                i++;
            }else{
                if(set.contains(tc[i])){
                    return false;
                }else{
                    map.put(sc[i],tc[i]);
                    set.add(tc[i]);
                    i++;
                }
                
            }

            } 
        return true;

        }

    }
