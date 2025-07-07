class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
        PriorityQueue<Integer> pq=new PriorityQueue();
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int day=events[0][0];
        int i=0;
        int count=0;

        while(!pq.isEmpty() || i<n){

            if(pq.isEmpty()){
                day=events[i][0];
            }
            while(i<n && events[i][0]==day){
                pq.add(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }
            day++;

            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
            
        }
        return count;


        
    }
}