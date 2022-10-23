import structure.TreeNode;

public class day3_symmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }
    public boolean isSame(TreeNode root1,TreeNode root2 ){
        if (root1==null ^ root2==null){
            return false;
        }
        if (root1==null&&root2==null){
            return true;
        }
        return root1.val==root2.val&&isSame(root1.left, root2.right)&&isSame(root1.right, root2.left);
    }

}
