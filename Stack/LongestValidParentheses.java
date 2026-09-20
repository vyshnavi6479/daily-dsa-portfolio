//LeetCode 32. Longest Valid Parentheses
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        int len=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')
            st.push(i);
            else if(ch==')'){
                st.pop();
                if(st.isEmpty())
                st.push(i);
                else
                len=Math.max(len,i-st.peek());
            }
        }
        return len;
    }
}