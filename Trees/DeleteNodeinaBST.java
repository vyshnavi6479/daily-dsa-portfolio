//LeetCode 450. Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        return root;
        if(root.val==key){
            if(root.left==null && root.right==null)
            return null;
            else if(root.left!=null && root.right!=null){
                TreeNode successor=inordersuccessor(root.right);
                root.val=successor.val;
                root.right=deleteNode(root.right,successor.val);
                return root;
            }
            else if(root.left!=null)
            return root.left;
            else
            return root.right;
        }
        if(key<root.val)
        root.left=deleteNode(root.left,key);
        else
        root.right=deleteNode(root.right,key);
        return root;
    }
    TreeNode inordersuccessor(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}