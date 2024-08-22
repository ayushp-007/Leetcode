class Solution {
    public int findComplement(int num) {
        int ans = 0;
        for(int i = 31 - Integer.numberOfLeadingZeros(num); i >= 0; i--) {
            ans |= (1 - ((num >> i) & 1)) << i;
        }
        return ans;
    }
}