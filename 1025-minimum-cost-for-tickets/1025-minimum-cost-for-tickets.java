import static java.lang.Math.*;
class Solution {
    Integer[] dp= new Integer[366];
    Set<Integer> set = new HashSet<>();
    public int mincostTickets(int[] days, int[] costs) {
        for(int i : days) set.add(i);
        return helper(365, days, costs);
    }
    public int helper(int day, int[] days, int[] costs) {
        if(day <= 0) return 0;
        if(dp[day] != null) return dp[day];
        if(set.contains(day)) {
            int ticket1 = helper(day - 1, days, costs) + costs[0];
            int ticket7 = helper(day - 7, days, costs) + costs[1];
            int ticket30 = helper(day - 30, days, costs) + costs[2];

            dp[day] = min(ticket1, min(ticket7, ticket30));
            return dp[day];
        }
        dp[day] = helper(day - 1, days, costs);
        return dp[day];
    }
}