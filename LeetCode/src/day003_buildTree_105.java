import structure.TreeNode;

import java.util.HashMap;

public class day003_buildTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||inorder==null){
            return null;
        }
        if (preorder.length!=inorder.length){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode build(int[] pre,int l1,int r1,int[] in,int l2,int r2,HashMap<Integer,Integer> map){
        if (l1>r1){
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]);
        if (l1==r1){
            return head;
        }
        int find = map.get(pre[l1]);
        //l1+find-l2可以理解为，从l1出发，走find-l2个值，是r1
        head.left = build(pre, l1+1, l1+find-l2, in, l2,find-1, map);
        //l1+find-l2+1可以理解为，从l1出发，走find-l2+1个位置，是新的l1
        head.right = build(pre, l1+find-l2+1, r1, in, find+1, r2,map );
        return head;
    }
}
