class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size=flowerbed.length;
        for(int i=0;i<size;i++){
            if(flowerbed[i]==0){
                boolean leftside=(i==0) || (flowerbed[i-1]==0);
                boolean rightside=(i==size-1)||(flowerbed[i+1]==0);
                if(leftside && rightside){
                    flowerbed[i]=1;
                    n--;
                    if(n==0){
                        return true;
                    }
                }
            }
        }
        return n<=0;
        
    }
}