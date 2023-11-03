class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> l = new ArrayList<>();
        int i = 0;
        int a = 1;
        while(i<target.length){
            if(target[i] == a){
                l.add("Push");
            }
            if(target[i] != a){
                l.add("Push");
                l.add("Pop");
                i--;
            }
            i++;
            a++;
        }
        return l;
    }
}