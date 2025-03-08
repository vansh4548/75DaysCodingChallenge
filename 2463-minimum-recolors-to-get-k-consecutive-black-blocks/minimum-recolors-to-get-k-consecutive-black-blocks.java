class Solution {
    public int minimumRecolors(String blocks, int k) {

        char[] arr=blocks.toCharArray();
        int n=arr.length;
        int whiteCount=0;
        int minchanges=Integer.MAX_VALUE;

        for(int i=0;i<k;i++){
            if(arr[i]=='W'){
                whiteCount++;
            }
        }
        minchanges=whiteCount;
        for(int i=k;i<n;i++){
            if(arr[i-k]=='W'){
                whiteCount--;
            }
            if(arr[i]=='W'){
                whiteCount++;
            }
            minchanges=Math.min(minchanges,whiteCount);
        }
        return minchanges;
        
    }
}