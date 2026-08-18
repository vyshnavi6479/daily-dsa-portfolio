//Tree Boundary Traversal (GFG)
/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer>al=new ArrayList<>();
        if(root==null)
        return al;
        al.add(root.data);
        if(root.left == null && root.right == null)
        return al;
        Deque<Integer>right=new ArrayDeque<>();
        leftboundary(root.left,al);
        leaf(root,al);
        rightboundary(root.right,right);
        al.addAll(right);
        return al;
        
    }
    void leftboundary(Node root,List<Integer>al){
        if(root==null)
        return;
        if(root.left!=null || root.right!=null)
        al.add(root.data);
        if(root.left!=null)
        leftboundary(root.left,al);
        else if(root.right!=null)
        leftboundary(root.right,al);
        else
        return;
        
    }
    void leaf(Node root,List<Integer>al){
        if(root==null)
        return;
        if(root.left==null && root.right==null){
            al.add(root.data);
            return;
        }
        leaf(root.left,al);
        leaf(root.right,al);
    }
    void rightboundary(Node root,Deque<Integer>right){
        if(root==null)
        return;
        if(root.left!=null || root.right!=null)
        right.addFirst(root.data);
        if(root.right!=null)
        rightboundary(root.right,right);
        else if(root.left!=null)
        rightboundary(root.left,right);
        else
        return;
    }
}