class Solution {
    public String reorganizeString(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : c) map.merge(ch, 1, Integer :: sum);
        for(int i : map.values()) {
            if(i > (n + 1) / 2) return "";
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1] - a[1]);
        for(char ch : map.keySet()) {
            pq.add(new int[]{(int)ch, map.get(ch)});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] a = pq.poll();
            if(pq.isEmpty()) {
                sb.append((char)(a[0]));
                break;
            }
            int[] b = pq.poll();
            sb.append((char)(a[0]));
            sb.append((char)(b[0]));
            if(a[1] > 1) pq.add(new int[]{a[0], a[1] - 1});
            if(b[1] > 1) pq.add(new int[]{b[0], b[1] - 1});
        }
        return sb.toString();
    }
}