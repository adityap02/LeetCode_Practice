class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Create an Adjacency List of the Prerequsites given (a HashMap)
        //Then Do DFS on each of the hashMap Keys (Courses)
        //If Any Course Repeated in dfs, there is a cycle
        //Else we go on doing dfs and check if cll courses can be completed 
        //O(V+E)
        //Key -> Course , Val -> All Prerequsites
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int p[] : prerequisites) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }
        //Set to Keep track of Courses in DFS that are already Seen and Also Detect Cycle
        Set<Integer> visiting = new HashSet<>();
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, map, visiting)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int course, Map<Integer, List<Integer>> map, Set<Integer> visiting) {
        if (visiting.contains(course)) {
            // Cycle detected
            return false;
        }
        if (map.containsKey(course)) {
            //means no prerequsite
            if (map.containsKey(course) && map.get(course).isEmpty()) {
                return true;
            }
            //Adding to Set so that we know it's seen
            visiting.add(course);
            //Doing DFS on remaining non Seen 
            for (int pre : map.get(course)) {
                if (!dfs(pre, map, visiting)) {
                    return false;
                }
            }
            visiting.remove(course);
        }
        map.put(course, new ArrayList<>());
        return true;
    }
}