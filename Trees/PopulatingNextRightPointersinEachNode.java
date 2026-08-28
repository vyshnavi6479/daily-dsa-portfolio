//LeetCode 116. Populating Next Right Pointers in Each Node
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
        return root;
        Node levelstart=root;
        root.next=null;
        while(levelstart.left!=null){
            Node curr=levelstart;
            while(curr!=null){
                curr.left.next=curr.right;
                if(curr.next!=null)
                curr.right.next=curr.next.left;
                else
                curr.right.next=null;
                curr=curr.next;
            }
            levelstart=levelstart.left;
        }
        return root;
    }
}