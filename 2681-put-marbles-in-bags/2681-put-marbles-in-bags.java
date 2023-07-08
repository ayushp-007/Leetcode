class Solution {
    public long putMarbles(int[] w, int k) {
        List<Long> l = new ArrayList<>();
        int n = w.length;
        for(int i = 0 ; i<n - 1; i++){
            l.add((long)w[i] + (long)w[i+1]);
        }
        Collections.sort(l);
        long a = 0,b = 0;
        for(int i = 0 ;i<k-1; i++) b += l.get(i);
        int t = 0;
        for(int i = n-2; t < k-1;t++) a+= l.get(i--);
        return a-b;
    }
}