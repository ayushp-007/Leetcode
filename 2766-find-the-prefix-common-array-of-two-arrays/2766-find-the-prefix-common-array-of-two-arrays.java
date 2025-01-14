class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] c = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++) {
            map.merge(A[i], 1, Integer :: sum);
            map.merge(B[i], 1, Integer :: sum);
            int cnt = 0;
            for(int j : map.values()) cnt += j == 2 ? 1 : 0;
            c[i] = cnt;
        }
        return c;
    }
}