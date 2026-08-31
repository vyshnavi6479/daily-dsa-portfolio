//SpaceOptimised
class Solution {
    public int climbStairs(int n) {
        if(n<=2)
        return n;
        int prev2=1;
        int prev1=2;
        for(int i=3;i<n+1;i++){
            int ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;
        }
        return prev1;
    }
}