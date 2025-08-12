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
   /* public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode>q=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();//for push and pop we use poll
            if(node==null){
                res.append("# ");
                continue;
            } 
            res.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString().trim();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        Queue<TreeNode>q=new LinkedList<>();
        String values[]=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent=q.poll();
            if(!values[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.add(left);
            }
           if (++i < values.length && !values[i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }*/
    public String serialize(TreeNode root) {
        if(root==null)return "#";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }
    public TreeNode deserialize(String data) {
        Queue<String>queue=new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    public TreeNode helper(Queue<String>queue){
        String s=queue.poll();
        if(s.equals("#")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(s));
        root.left=helper(queue);
        root.right=helper(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));