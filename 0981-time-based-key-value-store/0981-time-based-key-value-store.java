class TimeMap {
    Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            TreeMap<Integer,String> tree = map.get(key);
            tree.put(timestamp,value);
        }else{
            TreeMap<Integer,String> tree = new TreeMap<>();
            tree.put(timestamp,value);
            map.put(key,tree);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }else{
            TreeMap<Integer,String> tree = map.get(key);
            if(tree.containsKey(timestamp)){
                return tree.get(timestamp);
            }else{
                      var t =  tree.floorEntry(timestamp);
        return t != null ? t.getValue() : "";
            }
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */