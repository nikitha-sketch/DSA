/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder();
        preOrder(root,str);
        return str.toString().trim();
    }

    public void preOrder(TreeNode root,StringBuilder sb){
        if(root==null)return;
        sb.append(root.val).append(" ");
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return null;
        String values[]=data.split(" ");
        int preOrder[]=new int[values.length];
        for(int i=0;i<values.length;i++){
            preOrder[i]=Integer.parseInt(values[i]);
        }
        return buildBST(preOrder,new int[]{0},Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode buildBST(int preOrder[],int index[],int lower,int upper){
        if(index[0]==preOrder.length)return null;
        int value=preOrder[index[0]];
        if(value<lower || value>upper)return null;
        index[0]++;
        TreeNode root=new TreeNode(value);
        root.left=buildBST(preOrder,index,lower,value);
        root.right=buildBST(preOrder,index,value,upper);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;