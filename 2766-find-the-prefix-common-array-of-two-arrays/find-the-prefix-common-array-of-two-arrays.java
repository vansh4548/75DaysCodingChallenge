import java.util.HashSet;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        HashSet<Integer> seen = new HashSet<>();
        int common = 0;

        for (int i = 0; i < n; i++) {
            if (seen.contains(A[i])) {
                common++;
            } else {
                seen.add(A[i]);
            }

            if (seen.contains(B[i])) {
                common++;
            } else {
                seen.add(B[i]);
            }

            result[i] = common;
        }

        return result;
    }
}
