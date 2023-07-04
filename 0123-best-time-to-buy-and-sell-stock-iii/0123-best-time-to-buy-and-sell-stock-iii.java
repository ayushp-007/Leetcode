import static java.lang.Math.*;
class Solution {
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for(int i : prices) {
            buy1 = max(buy1, -i);
            sell1 = max(sell1, buy1 + i);
            buy2 = max(buy2, sell1 - i);
            sell2 = max(sell2, buy2 + i);
        } 
        return sell2;
    }
}