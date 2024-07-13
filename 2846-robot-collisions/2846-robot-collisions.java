class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<int[]> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        int n = healths.length;
        int[][] a = new int[n][];
        for(int i = 0; i<n; i++) {
            a[i] = new int[]{positions[i], healths[i], directions.charAt(i) == 'R' ? 1 : 0, i};
        }
        Arrays.sort(a, (x,y)->x[0] - y[0]);
        for(int i = 0; i<n; i++) {
            if(st.isEmpty()) st.add(new int[]{a[i][1], a[i][2], a[i][3]});
            else if(a[i][2] == 0 && st.peek()[1] == 1) {
                if(a[i][1] == st.peek()[0]) st.pop();
                else if(a[i][1] > st.peek()[0]) {
                    st.pop();
                    int val = a[i][1] - 1;
                    while(!st.isEmpty() && st.peek()[1] == 1) {
                        if(st.peek()[0] < val) { 
                            st.pop();
                            val--;
                        }
                        else if(st.peek()[0] == val) {
                            st.pop();
                            val = 0;
                            break;
                        }
                        else if(st.peek()[0] > val) {
                            var v = st.pop();
                            val = 0;
                            st.add(new int[]{v[0] - 1, v[1], v[2]});
                            break;
                        }
                    }
                    if(val != 0) st.add(new int[]{val, a[i][2], a[i][3]});
                }
                else if(a[i][1] < st.peek()[0]) {
                    var val = st.pop();
                    st.add(new int[]{val[0] - 1, val[1], val[2]});
                }
            }
            else st.add(new int[]{a[i][1], a[i][2], a[i][3]});
        }
        List<int[]> temp = new ArrayList<>();
        for(var i : st) temp.add(i);
        Collections.sort(temp, (x, y)-> x[2] - y[2]);
        for(var i : temp) {
            ans.add(i[0]);
        }
        return ans;
    }
}