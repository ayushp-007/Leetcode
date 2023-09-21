class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        int mask = 0;
        for(char c : s.toCharArray()) {
            mask ^= (1 << (c - 'a'));
            list.add(mask);
        }
        List<Boolean> ans = new ArrayList<>();
        for(var i : queries) {
            int curr = list.get(i[1]);
            if(i[0] > 1) curr ^= list.get(i[0] - 1);
            int cnt = Integer.bitCount(curr);
            if(cnt / 2 <= i[2]) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}