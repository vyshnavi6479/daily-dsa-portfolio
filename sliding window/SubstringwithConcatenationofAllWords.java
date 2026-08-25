//LeetCode 30. Substring with Concatenation of All Words
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer>hm1=new HashMap<>();
        List<Integer>al=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            hm1.put(words[i],hm1.getOrDefault(words[i],0)+1);
        }
        int n=words[0].length();
        for(int i=0;i<n;i++){
            int have=0,start=i;
            HashMap<String,Integer>hm2=new HashMap<>();
            for(int j=i;j<s.length();j=j+n){
                if(j+n<=s.length() && hm1.containsKey(s.substring(j,j+n))){
                    hm2.put(s.substring(j,j+n),hm2.getOrDefault(s.substring(j,j+n),0)+1);
                    have++;
                    while(j+n<=s.length() && hm2.get(s.substring(j,j+n))>hm1.get(s.substring(j,j+n))){
                        hm2.put(s.substring(start,start+n),hm2.get(s.substring(start,start+n))-1);
                        have--;
                        start=start+n;
                    }
                }
                else{
                    hm2.clear();
                    have=0;
                    start=j+n;
                }
                
                while(have==words.length){
                    al.add(start);
                    hm2.put(s.substring(start,start+n),hm2.get(s.substring(start,start+n))-1);
                    have--;
                    start=start+n;
                }
            }
        }
        return al;
    }
}