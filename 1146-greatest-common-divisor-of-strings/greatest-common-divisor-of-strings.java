class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int gcdString=gcd(str1.length(),str2.length());
        String candidate= str1.substring(0,gcdString);

        if(str1.equals(candidate.repeat(str1.length()/gcdString)) && 
        str2.equals(candidate.repeat(str2.length()/gcdString))){
            return candidate;
        }
        return "";
        
    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}