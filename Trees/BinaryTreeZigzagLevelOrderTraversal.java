//LeetCode 103. Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        Deque<TreeNode>dq=new ArrayDeque<>();
        Boolean var=false;
        if(root==null)return ans;
        dq.addFirst(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            Deque<Integer>al=new ArrayDeque<>();
            for(int i=0;i<size;i++){
                TreeNode n=dq.removeFirst();
                if(var)
                al.addFirst(n.val);
                else
                al.add(n.val);
                if(n.left!=null)
                dq.add(n.left);
                if(n.right!=null)
                dq.add(n.right);
            }
            ans.add(new ArrayList<>(al));
            var=!var;
        }
        return ans;

    }
}