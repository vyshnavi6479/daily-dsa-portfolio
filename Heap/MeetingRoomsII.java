//Meeting Rooms II
//GFG problem
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        int[][] meetings=new int[start.length][2];
        for(int i=0;i<start.length;i++)
        {
            meetings[i][0]=start[i];
            meetings[i][1]=end[i];
        }
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int rooms=1;
        pq.add(meetings[0][1]);
        for(int i=1;i<start.length;i++){
            while(!pq.isEmpty() && meetings[i][0]>=pq.peek())
            pq.poll();
            pq.add(meetings[i][1]);
            rooms=Math.max(rooms,pq.size());
        }
        return rooms;
    }
}
