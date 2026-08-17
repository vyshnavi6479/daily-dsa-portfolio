//LeetCode 987. Vertical Order Traversal of a Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair>q=new LinkedList<>();
        TreeMap<Integer,List<Integer>>tm=new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            HashMap<Integer,List<Integer>>hm=new HashMap<>();
            for(int i=0;i<size;i++){
                Pair p=q.remove();
                hm.computeIfAbsent(p.col, k -> new ArrayList<>()).add(p.node.val);
                if(p.node.left!=null)
                q.add(new Pair(p.node.left,p.col-1));
                if(p.node.right!=null)
                q.add(new Pair(p.node.right,p.col+1));
            }
            for(Map.Entry<Integer,List<Integer>>entry:hm.entrySet()){
                List<Integer>list=entry.getValue();
                Collections.sort(list);
                tm.computeIfAbsent(entry.getKey(),k->new ArrayList<>()).addAll(entry. getValue());
            }
        }
        List<List<Integer>>al=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>>entry:tm.entrySet())
        {
            al.add(entry.getValue());
        }
        return al;
    }
}
class Pair{
    TreeNode node;
    int col;
    Pair(TreeNode node,int col){
        this.node=node;
        this.col=col;
    }
}