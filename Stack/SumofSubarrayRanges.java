//2104. Sum of Subarray Ranges
class Solution {
    public long subArrayRanges(int[] nums) {
        int maxarr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            maxarr[i]=-nums[i];
        }
        return -sum(nums)-sum(maxarr);
    }
    long sum(int[] nums){
        Deque<Integer>st=new ArrayDeque<>();
        int left[]=new int[nums.length];
        int right[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
            st.pop();
            if(st.isEmpty())
            left[i]=i+1;
            else
            left[i]=i-st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])
            st.pop();
            if(st.isEmpty())
            right[i]=nums.length-i;
            else
            right[i]=st.peek()-i;
            st.push(i);
        }
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+(long)left[i]*nums[i]*right[i];
        }
        return sum;
    }
}