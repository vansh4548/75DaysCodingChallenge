class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[] result=new int[2];
        
        int[] frequency=new int[n*n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=grid[i][j];
                frequency[num]++;
            }
        }

        for(int i=0;i<=n*n;i++){
            if(frequency[i]==2){
                result[0]=i;
            }
            else if(frequency[i]==0){
                result[1]=i;
            }
        }
        return result;

        
    }
}