import static java.lang.Math.*;
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for(int i = low; i<=high; i++) {
            int n = cnt(i);
            if(n % 2 == 1) continue;
            int a = i / (int)pow(10, n / 2), b = i % (int)pow(10, n / 2);
            if(sum(a) == sum(b)) cnt++;
        }
        return cnt;
    }
    public int cnt(int n) {
        int cnt = 0;
        while(n > 0) {
            n /= 10;
            cnt++;
        }
        return cnt;
    }
    public int sum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}