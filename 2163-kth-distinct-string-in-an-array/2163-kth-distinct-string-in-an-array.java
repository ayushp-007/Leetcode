class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(var i : arr) map.merge(i, 1, Integer :: sum);
        for(var i : arr) {
            if(map.get(i) == 1) {
                k--;
                if(k == 0) return i;
            }
        }
        return "";
    }
}