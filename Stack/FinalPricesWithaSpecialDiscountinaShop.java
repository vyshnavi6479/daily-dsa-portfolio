//Leetcode 1475. Final Prices With a Special Discount in a Shop
class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> st=new ArrayDeque<>();
        int ans[]=new int[prices.length];
        for(int i=0;i<prices.length;i++){
            while(!st.isEmpty() && prices[i]<=prices[st.peek()] && st.peek()<i){
                int j=st.pop();
                ans[j]=prices[j]-prices[i];
            }
            st.push(i);   
        }
        while(!st.isEmpty()){
            int j=st.pop();
            ans[j]=prices[j];
        }
        return ans;
    }
}