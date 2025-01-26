class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        double ans=0;
        double window=0;
        int n=nums.length;

        for(int i=0;i<k;i++){
            window+=nums[i];
    }
    ans=window/k;
    for(int right=k;right<n;right++){
        window+=nums[right]-nums[right-k];
        ans=Math.max(ans,window/k);
    }
    return ans;

        
    }
}