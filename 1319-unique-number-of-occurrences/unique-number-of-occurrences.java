import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> uniqueFrequencies = new HashSet<>();
        for (int frequency : frequencyMap.values()) {
            if (!uniqueFrequencies.add(frequency)) {
                return false;
            }
        }
        return true;
    }
}
