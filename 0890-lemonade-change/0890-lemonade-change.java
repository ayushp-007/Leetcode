class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int i : bills) {
            if(i == 5) five += 1;
            if(i == 10) ten += 1;
            int val = i - 5;
            int x = val / 10;
            if(x <= ten) {
                ten -= x;
                val -= x * 10;
            }
            else {
                val -= ten * 10;
                ten = 0;
            }
            x = val / 5;
            if(x <= five) {
                five -= x;
                val -= x * 5;
            }
            else {
                val -= five * 5;
                five = 0;
            }
            if(val != 0) return false;
        }
        return true;
    }
}