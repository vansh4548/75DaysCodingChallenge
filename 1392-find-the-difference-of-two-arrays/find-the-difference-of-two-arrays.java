class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> seen1=new HashSet<>();
        HashSet<Integer> seen2=new HashSet<>();
        for(int num:nums1){
            seen1.add(num);
        }
        for(int num:nums2){
            seen2.add(num);
        }
        List<Integer> ans1=new ArrayList<>(seen1);
        ans1.removeAll(seen2);

        List<Integer> ans2=new ArrayList<>(seen2);
        ans2.removeAll(seen1);

        List<List<Integer>> result=new ArrayList<>();
        result.add(ans1);
        result.add(ans2);

        return result;
    }
}