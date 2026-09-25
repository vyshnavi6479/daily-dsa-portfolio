//LeetCode 1642. Furthest Building You Can Reach
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            if(heights[i]<heights[i+1])
            pq.add(heights[i+1]-heights[i]);
            else
            ans++;
            if(pq.size()>ladders){
                int req=pq.poll();
                if(bricks>=req){
                    bricks=bricks-req;
                    ans++;
                }
                else
                return ans+pq.size();
            }
        }
        return ans+pq.size();
    }
}