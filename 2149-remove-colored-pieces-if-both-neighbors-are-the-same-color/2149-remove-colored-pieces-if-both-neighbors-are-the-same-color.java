class Solution {
    public boolean winnerOfGame(String colors) {
        char[] c = colors.toCharArray();
        int n = c.length, cntA = 0, cntB = 0;
        for(int i = 1; i < n - 1; i++) {
            if(c[i] == 'A' && c[i - 1] == 'A' && c[i + 1] == 'A') cntA++;
            if(c[i] == 'B' && c[i - 1] == 'B' && c[i + 1] == 'B') cntB++;
        }
        return cntA > cntB;
    }
}