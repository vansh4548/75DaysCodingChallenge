class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map=new HashMap<>();
        int result=0;
        for(String word:words){
            String reversed=new StringBuilder(word).reverse().toString();
            if(map.getOrDefault(reversed,0)>0){
                result+=4;
                map.put(reversed,map.get(reversed)-1);
            }
            else{
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }
        for(String key:map.keySet()){
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                result += 2;
                break;
            }
        }
        return result;
        
    }
}