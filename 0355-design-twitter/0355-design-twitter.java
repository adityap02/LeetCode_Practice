class Twitter {

    //Follow and unfollow in O(1) using Set
    //UserId -> List of FollowerID
    Map<Integer, Set<Integer>> followerList;
    //Userid -> [time,TweetId]
    Map<Integer, List<int[]>> feed;
    int time;

    public Twitter() {
        followerList = new HashMap<>();
        time = 0;
        feed = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        int[] pair = new int[] { time, tweetId };
        feed.computeIfAbsent(userId, k -> new ArrayList<>()).add(pair);
        if (feed.get(userId).size() > 10) {
            feed.get(userId).remove(0);
        }
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        //Descending Order of Time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //user follow himself
        followerList.computeIfAbsent(userId, k-> new HashSet<>()).add(userId);
        if(followerList.get(userId).size()>=10){
            //if user has more than 10 followers ,then need to sort top 10 recent tweets from all those followers
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
            for (int fId : followerList.get(userId)) {
                if(!feed.containsKey(fId)){
                    continue;
                }
                 List<int[]> tweets = feed.get(fId);
                 int index = tweets.size() - 1;
                 int[] tweet = tweets.get(index);
                pq.offer(new int[] {tweet[0], tweet[1], fId , index - 1 });
                //time, tweetId, followeeId , 
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
            while (!pq.isEmpty()) {
                int[] top = pq.poll();
                minHeap.offer(new int[]{top[0], top[1], top[2], top[3]});
            }
        }else{
                for (int followeeId : followerList.get(userId)) {
                if (!feed.containsKey(followeeId)) continue;
                List<int[]> tweets = feed.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index - 1});
            }
        }

        while (!minHeap.isEmpty() && ans.size() < 10) {
            int[] top = minHeap.poll();
            ans.add(top[1]);
            int nextIndex = top[3];
            if (nextIndex >= 0) {
                List<int[]> tweets = feed.get(top[2]);
                int[] nextTweet = tweets.get(nextIndex);
                minHeap.offer(new int[]{nextTweet[0], nextTweet[1], top[2], nextIndex - 1});
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followerList.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerList.containsKey(followerId)) {
            followerList.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */