class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int sum=nums[0];
        pre[0]=0;
        for(int i=1;i<n;i++){
            sum+=nums[i];
            pre[i]=pre[i-1]+nums[i-1];
        }
        for(int i=0;i<n;i++){
            if(pre[i]==sum-pre[i]-nums[i]){
                return i;
            }
        }
        return -1;
    }
}