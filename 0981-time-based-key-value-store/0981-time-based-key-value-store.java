// class TimeMap {
//     Map<String, TreeMap<Integer, String>> map;
//     public TimeMap() {
//         map = new HashMap<>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         if(!map.containsKey(key)){
//         TreeMap<Integer,String> tMap = new TreeMap<>(Comparator.reverseOrder());
//         tMap.add(timeStamp,value);
//         map.put(key,tMap);
//         }else{
//             TreeMap<Integer,String> tMap = map.get(key);
//             tMap.add(timeStamp,value);
//             //map.put(key,tMap);
//         }
//     }
    
//     public String get(String key, int timestamp) {
//         if(map.containsKey(key)){
//             TreeMap<Integer,String> tMap = map.get(key);
//             if(tMap.containsKey(timestamp)){
//                 return tMap.get(timestamp);
//             }else{
//                 Integer k = tree.floorKey(timestamp);
//                 if(k == null){
//                     return "";
//                 }else{
//                     return tree.get(k);
//                 }
//             }
//         }else{
//             return "";
//         } 
//     }
// }



//Binary Search
class TimeMap {
    Map<String, List<Pair<Integer,String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<Pair<Integer,String>> list = map.get(key);
            list.add(new Pair(timestamp,value));
            map.put(key,list);
        }else{
           List<Pair<Integer,String>> list = new ArrayList<>();
           list.add(new Pair(timestamp,value));
           map.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if(map.containsKey(key)){
            List<Pair<Integer,String>> list = map.get(key);
            int l =0 , r = list.size()-1;
            //Binary Search
            while(l<=r){
                int m = (l+r)/2;

                if(list.get(m).getKey() == timestamp){
                    return list.get(m).getValue();
                }else if(list.get(m).getKey()<timestamp){
                    result= list.get(m).getValue();
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
        }else{
            return "";
        }
        return result; 
    }
}



/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */