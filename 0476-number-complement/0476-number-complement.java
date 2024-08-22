class Solution {
    public int findComplement(int num) {
        return ((1 << (31 - Integer.numberOfLeadingZeros(num) + 1)) - 1) ^ num;
    }
}