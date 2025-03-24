import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); 
        
        int freeDays = 0;
        int currentDay = 1;
        
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
    
            if (currentDay < start) {
                freeDays += (start - currentDay);
            }
          
            currentDay = Math.max(currentDay, end + 1);
        }
    
        if (currentDay <= days) {
            freeDays += (days - currentDay + 1);
        }
        
        return freeDays;
    }
}
