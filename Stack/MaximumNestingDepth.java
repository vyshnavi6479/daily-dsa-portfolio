//LeetCode 1614. Maximum Nesting Depth of the Parentheses
class Solution {
    public int maxDepth(String s) {
        int depth=0;
        Stack<Character>st=new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='('){
                st.push(ch);
                depth=Math.max(st.size(),depth);
            }
            else if(ch==')'){
                st.pop();
            }
        }
        return depth;
    }
}