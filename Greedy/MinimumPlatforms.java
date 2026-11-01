//Minimum Platforms
//GFG
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0,p=0,maxp=0,n=arr.length;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                p++;
                i++;
            }
            else{
                p--;
                j++;
            }
            maxp=Math.max(p,maxp);
        }
        return maxp;
        
    }
}
