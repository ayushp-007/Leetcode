class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        for(int i = 0; i<aliceValues.length; i++) 
            pq.add(new int[]{aliceValues[i] + bobValues[i], i});
        boolean flip = true;
        int a = 0, b = 0;
        while(!pq.isEmpty()) {
            if(flip) a += aliceValues[pq.poll()[1]];
            else b += bobValues[pq.poll()[1]];
            flip = !flip;
        }
        return a == b ? 0 : a > b ? 1 : -1;
    }
}