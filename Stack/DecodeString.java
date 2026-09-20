//LeetCode 394. Decode String
class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1=new Stack<>();
        Stack<String> st2=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int num=0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10 +(ch-'0');
            }
            else if(ch=='['){
                st1.push(num);
                st2.push(sb.toString());
                num=0;
                sb=new StringBuilder();
                
            }
            else if(ch==']'){
                String prevs=st2.pop();
                int prevn=st1.pop();
                StringBuilder temp=new StringBuilder(prevs);
                for(int i=0;i<prevn;i++){
                    temp.append(sb);
                }
                sb=temp;
            }
            else
            sb.append(ch);
        }
        return sb.toString();
        
    }
}