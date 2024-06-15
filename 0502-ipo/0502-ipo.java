import static java.lang.Math.*;
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> project = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> select = new PriorityQueue<>(Collections.reverseOrder());
        int n = profits.length;
        for(int i = 0; i<n; i++){
            project.add(new int[]{profits[i], capital[i]});
        }
        k = min(k, n);
        while(k-->0){
            while(!project.isEmpty() && project.peek()[1] <= w){
                select.add(project.poll()[0]);
            }
            if(!select.isEmpty()) w += select.poll();
        }
        return w;
    }
}