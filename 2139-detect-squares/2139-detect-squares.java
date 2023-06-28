import static java.lang.Math.*;
class DetectSquares {
    int[][] cnt;
    List<int[]> points;
    public DetectSquares() {
        cnt = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        cnt[point[0]][point[1]]++;
        points.add(point);
    }
    
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1], ans = 0;
        for(var i : points) {
            int x3 = i[0], y3 = i[1];
            if(abs(x1 - x3) == 0 || abs(x1 - x3) != abs(y1 - y3)) continue;
            ans += cnt[x1][y3] * cnt[x3][y1];
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */