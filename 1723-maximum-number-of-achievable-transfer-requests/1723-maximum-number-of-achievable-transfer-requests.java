import static java.lang.Math.*;
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        return helper(0, n, indegree, requests, 0);
    }
    public int helper(int idx, int n, int[] indegree, int[][] requests, int cnt) {
        if(idx == requests.length) {
            for(int i = 0; i<n; i++) if(indegree[i] != 0) return 0;
            return cnt;
        }
        indegree[requests[idx][0]]--;
        indegree[requests[idx][1]]++;
        int take = helper(idx + 1, n, indegree, requests, cnt + 1);
        indegree[requests[idx][0]]++;
        indegree[requests[idx][1]]--;
        int notTake = helper(idx + 1, n, indegree, requests, cnt);
        return max(take, notTake);
    }
}