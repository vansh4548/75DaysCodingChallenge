import java.util.*;

public class Solution {
    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> resultSet = new HashSet<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; 

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        resultSet.add(num);
                    }
                }
            }
        }

        List<Integer> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);


        int[] res = new int[resultList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }
}
