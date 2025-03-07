class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes=new ArrayList<>();

        for(int i=left;i<=right;i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
        if(primes.size()<2){
            return new int[]{-1,-1};
        }

        int minDiff=Integer.MAX_VALUE;
        int[] result=new int[2];

        for(int i=1;i<primes.size();i++){
            int diff=primes.get(i) - primes.get(i-1);
            if(diff<minDiff){
                minDiff=diff;
                result[0]=primes.get(i-1);
                result[1]=primes.get(i);
            }
        }
        return result;


    }
    private boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}