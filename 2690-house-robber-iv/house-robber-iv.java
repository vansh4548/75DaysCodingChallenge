class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int) 1e9, res = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (rob(nums, k, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return res;
    }
    private boolean rob(int[] nums,int k,int maxCap){
        int count=0,i=0;
        while(i<nums.length){
            if(nums[i]<=maxCap){
                count++;
                i++;
            }
            i++;
        }
        return count>=k;
    }
}