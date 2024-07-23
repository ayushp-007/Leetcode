class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] f = new int[201];
        for(int i : nums) f[i + 100]++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int[] ans = new int[n];
        int idx = 0;
        for(int i = -100; i <= 100; i++) if(f[i + 100] != 0) pq.add(new int[]{i, f[i + 100]});
        while(!pq.isEmpty()) {
            var t = pq.poll();
            while(t[1]-->0) ans[idx++] = t[0];
        }
        return ans;
    }
}