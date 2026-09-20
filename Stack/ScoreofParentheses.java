//LeetCode 856. Score of Parentheses
class Solution {
    public int scoreOfParentheses(String s) {
        int score=0,pairscore=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
            {
                st.push(score);
                score=0;
            }
            else{
                if(score==0)
                pairscore=1;
                else
                pairscore=2*score;
                score=st.pop()+pairscore;
            }
            
        }
        return score;
    }
}