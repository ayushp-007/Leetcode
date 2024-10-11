class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> chair = new PriorityQueue<>();
        for(int i = 0; i<times.length; i++) chair.add(i);
        int target = times[targetFriend][0];
        Arrays.sort(times, (a,b)->a[0]-b[0]);
        for(int i = 0; i<times.length; i++) {
            while(!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                chair.add(pq.poll()[1]);
            }
            if(times[i][0] == target) break;
            pq.add(new int[]{times[i][1], chair.poll()});
        }
        return chair.peek();
    }
}