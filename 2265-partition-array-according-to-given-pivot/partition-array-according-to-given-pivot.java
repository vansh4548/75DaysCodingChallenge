class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : less) result[index++] = num;
        for (int num : equal) result[index++] = num;
        for (int num : greater) result[index++] = num;

        return result;
    }
}
