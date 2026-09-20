//LeetCode 921. Minimum Add to Make Parentheses Valid
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        for(char ch :s.toCharArray()){
            if(ch=='(')
            st.push(ch);
            else{
                if(!st.isEmpty())
                st.pop();
                else{
                    count++;
                }
            }
        }
        if(!st.isEmpty())
        count +=st.size();
        return count;
    }
}