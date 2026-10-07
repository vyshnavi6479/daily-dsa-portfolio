//Previous Greater Element
//GFG
class Solution {
    public ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        ArrayList<Integer>al=new ArrayList<>();
        Deque<Integer>st=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
            st.pop();
            if(st.isEmpty())
            al.add(-1);
            else
            al.add(arr[st.peek()]);
            st.push(i);
        }
        return al;
    }
}