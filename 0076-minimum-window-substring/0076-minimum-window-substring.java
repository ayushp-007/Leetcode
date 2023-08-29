import static java.lang.Math.*;
class Solution {
    public String minWindow(String s, String t) {
        char[] a = s.toCharArray();
        int[] f1 = new int[58], f2 = new int[58];
        int x = 0, y = 0, i = 0, j = 0, min = Integer.MAX_VALUE, start = -1, end = -1;
        for(char c : t.toCharArray()) {
            if(f2[c - 'A'] == 0) y++;
            f2[c - 'A']++;
        }
        while(i <= j && j < a.length) {
            f1[a[j] - 'A']++;
            if(f1[a[j] - 'A'] == f2[a[j] - 'A']) x++;
            while(i <= j && x == y) {
                if(min > (j - i + 1)) {
                    start = i;
                    end = j;
                    min = j - i + 1;
                }
                f1[a[i] - 'A']--;
                if(f1[a[i] - 'A'] < f2[a[i] - 'A']) x--;  
                i++;
            }
            j++;
        }
        if(start == -1 || end == -1) return "";
        return s.substring(start, end + 1);
    }
}