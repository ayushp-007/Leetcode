class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int i : banned) set.add(i);
        int cnt = 0;
        int sum = 0;
        for(int i = 1; i<=n ;i++){
            if(set.contains(i)) continue;
            sum += i;
            if(sum > maxSum) break;
            cnt++;
        }
        return cnt;
    }
}