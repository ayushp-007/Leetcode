class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Pair<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new Pair(names[i], heights[i]));
        }
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        for(int i = 0; i < names.length; i++) {
            names[i] = list.get(i).getKey();
        }
        return names;
    }
}