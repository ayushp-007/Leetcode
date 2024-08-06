class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : word.toCharArray()) map.merge(c, 1, Integer :: sum);
        List<Pair<Character, Integer>> list = new ArrayList<>();
        for(char c : map.keySet()) list.add(new Pair(c, map.get(c)));
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        int cnt = 0, mul = 1, ans = 0;
        for(var i : list) {
            ans += (i.getValue() * (1 * mul));
            cnt++;
            if(cnt % 8 == 0) {
                cnt = 0;
                mul++;
            }
        }
        return ans;
    }
}