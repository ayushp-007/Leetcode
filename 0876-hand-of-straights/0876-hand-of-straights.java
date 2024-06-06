class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand) map.merge(i, 1, Integer :: sum);
        while(!map.isEmpty()) {
            int x = map.firstKey();
            map.merge(x, -1, Integer :: sum);
            if(map.get(x) == 0) map.remove(x);
            for(int i = 1; i < groupSize; i++) {
                if(!map.containsKey(x + i)) return false;
                map.merge(x + i, -1, Integer :: sum);
                if(map.get(x + i) == 0) map.remove(x + i);
            }
        }
        return true;
    }
}