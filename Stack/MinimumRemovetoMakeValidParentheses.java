//LeetCode 1249. Minimum Remove to Make Valid Parentheses
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer>st=new Stack<>();
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
            st.push(i);
            else if(s.charAt(i)==')'){
                if(!st.isEmpty())
                st.pop();
                else
                hs.add(i);
            }
        }
        while(!st.isEmpty())
        hs.add(st.pop());    
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(hs.contains(i))
            continue;
            else
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}