class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for(int i : arr) {
            cnt += i % 2 == 1 ? 1 : -cnt;
            if(cnt == 3) return true;
        }
        return false;
    }
}