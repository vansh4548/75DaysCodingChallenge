class Solution {
    public int longestStrChain(String[] words) {

        Arrays.sort(words,(a,b) -> a.length() - b.length());

        Map<String,Integer> dp=new HashMap<>();

        int maxchain=1;

        for(String word:words){
            dp.put(word,1);

            for(int i=0;i<word.length();i++){
                StringBuilder sb=new StringBuilder(word);
                sb.deleteCharAt(i);
                String pred=sb.toString();
                if(dp.containsKey(pred)){
                    dp.put(word,Math.max(dp.get(word),dp.get(pred)+1));
                }
            }
            maxchain=Math.max(maxchain,dp.get(word));
        }
        return maxchain;
        
    }
}