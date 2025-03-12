class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int ans=0;
        int positive=0;
        int negative=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                positive++;
            }
            else if(nums[i]<0){
                negative++;
            }
        }
        ans=Math.max(positive,negative);
        return ans;
    }
}