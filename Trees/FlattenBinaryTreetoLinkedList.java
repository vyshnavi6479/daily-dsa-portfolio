//LeetCode 114. Flatten Binary Tree to Linked List
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
    public void flatten(TreeNode root) {
        if(root==null)
        return;
        Stack<TreeNode>st=new Stack<>();
        st.push(root);
        TreeNode prev=root;
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            if(curr.right!=null)
            st.push(curr.right);
            if(curr.left!=null)
            st.push(curr.left);
            if(curr!=root){
                prev.left=null;
                prev.right=curr;
            }
            prev=curr;
        }
    }
}