class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1) cnt++;
                else break;
            }
            list.add(new int[]{cnt, i});
        }
        int[] ans = new int[k];
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < k; i++) ans[i] = list.get(i)[1];
        return ans;
    }
}