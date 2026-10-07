//LeetCode 71. Simplify Path
class Solution {
    public String simplifyPath(String path) {
        String[] s=path.split("/");
        Deque<String> ans=new ArrayDeque<>();
        for(int i=0;i<s.length;i++){
            if(s[i].equals("..")){
                if(!ans.isEmpty())
                ans.pop();
            }
            else if(s[i].equals(".") || s[i].equals("")){
                continue;
            }
            else
            ans.push(s[i]);
        }
        if(ans.isEmpty())
        return "/";
        StringBuilder sb=new StringBuilder();
        while(!ans.isEmpty()){
            sb.append("/");
            sb.append(ans.removeLast());
        }
        return sb.toString();
    }
}