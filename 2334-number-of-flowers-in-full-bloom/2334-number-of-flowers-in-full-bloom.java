import static java.lang.Math.*;
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length, m = people.length;
        int[] a = new int[n], b = new int[n], ans = new int[m];
        for(int i = 0 ; i < n; i++) {
            a[i] = flowers[i][0];
            b[i] = flowers[i][1];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i < m; i++) {
            ans[i] = upper_bound(a, people[i]) - lower_bound(b, people[i]);
        }
        return ans;
    }
    public int upper_bound(int a[], int x) {
        int l=-1,r=a.length;
        while(l+1<r) {
            int m=(l+r)>>>1;
            if(a[m]<=x) l=m;
            else r=m;
        }
        return l+1;
    }
    public int lower_bound(int a[], int x) {
        int l=-1,r=a.length;
        while(l+1<r) {
            int m=(l+r)>>>1;
            if(a[m]>=x) r=m;
            else l=m;
        }
        return r;
    }
}