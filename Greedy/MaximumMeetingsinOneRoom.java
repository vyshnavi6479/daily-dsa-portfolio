//Maximum Meetings in One Room
//GFG
class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        int arr[][]=new int[s.length][2];
        for(int i=0;i<s.length;i++){
            arr[i][0]=i;
            arr[i][1]=f[i];
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        ArrayList<Integer>al=new ArrayList<>();
        int last[]=arr[0];
        al.add(last[0]+1);
        for(int i=1;i<s.length;i++){
            if(s[arr[i][0]]>last[1]){
                al.add(arr[i][0]+1);
                last=arr[i];
            }
        }
        Collections.sort(al);
        return al;
        
    }
}