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
    public List<Integer> inorderTraversal(TreeNode root) {
       /* List<Integer>inorder=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        TreeNode node=root;
        while(node!=null || !st.isEmpty()){
            while(node!=null){
                st.push(node);
                node=node.left;
            }
            
            node=st.pop();
            inorder.add(node.val);
            node=node.right;
        }
        return inorder;*/
        List<Integer>res=new ArrayList<>();
        inorder(root,res);
        return res;
    }
        public void inorder(TreeNode node, List<Integer> res){
            if(node==null)return;
            inorder(node.left,res);
            res.add(node.val);
            inorder(node.right,res);
        }
}