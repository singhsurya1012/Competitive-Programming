package medium;

import java.util.*;

public class DesignTwitter {

    private static int timeStamp = 0;

    class Twitter {

        /**
         * Initialize your data structure here.
         */

        Map<Integer, User> userMap;

        public Twitter() {
            userMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {

            if (!userMap.containsKey(userId)) {
                User u = new User(userId);
                userMap.put(userId, u);
            }
            userMap.get(userId).post(tweetId);
        }


        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> result = new LinkedList<>();

            if (!userMap.containsKey(userId))
                return result;

            Set<Integer> users = userMap.get(userId).followed;

            PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
            for(int user: users){
                Tweet tweet = userMap.get(user).tweet_head;
                if(tweet!=null){
                    q.add(tweet);
                }
            }

            int tweets=0;
            while(!q.isEmpty() && tweets<10){
                Tweet tweet = q.poll();
                result.add(tweet.id);
                tweets++;
                if(tweet.next!=null)
                    q.add(tweet.next);
            }

            return result;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {

            if (!userMap.containsKey(followerId)) {
                User follower = new User(followerId);
                userMap.put(followerId, follower);
            }
            if (!userMap.containsKey(followeeId)) {
                User followee = new User(followeeId);
                userMap.put(followeeId, followee);
            }
            userMap.get(followerId).follow(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {

            if (followerId == followeeId || !userMap.containsKey(followerId))
                return;
            userMap.get(followerId).unfollow(followeeId);
        }

    }

    class Tweet {

        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    class User {

        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
    }
}
