class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        int n = arr1.length;
        int[][] a = new int[n][];
        for(int i = 0; i < n; i++) {
            a[i] = new int[]{arr1[i], map.getOrDefault(arr1[i], n)};
        }
        Arrays.sort(a, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        for(int i = 0; i < n; i++) arr1[i] = a[i][0];
        return arr1;
    }
}