class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int sum = skill[n-1]+skill[0];
        long prod = skill[n-1]*skill[0];
        int l = 1, r = n-2;
        while(l < r){
            if(skill[r]+skill[l] != sum) return -1;
            prod += skill[r]*skill[l];
            l++;
            r--;
        }
        return prod;
    }
}