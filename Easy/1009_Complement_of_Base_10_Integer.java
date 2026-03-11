class Solution {
    public int bitwiseComplement(int n) {
        for(int i = 2; i <= Integer.MAX_VALUE; i *= 2) {
            if(i > n) return i - 1 - n;
        }
        return -1;
    }
}