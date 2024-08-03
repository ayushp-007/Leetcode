class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] a = new int[1001], b = new int[1001];
        for(int i : target) a[i]++;
        for(int i : arr) b[i]++;
        return Arrays.equals(a, b);
    }
}