
public class SymmetricTree
{
    public boolean isSymmetric(TreeNode root) 
    {
        if (root==null) return true;
        return isSymmetricCheck(root.left,root.right);
    }
    private boolean isSymmetricCheck(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) return true; // end of tree or leaf nodes.
        if(left==null || right==null) return false; // asymmetric
        if(left.val==right.val) return isSymmetricCheck(left.left,right.right) && isSymmetricCheck(left.right,right.left); // remaining checks
        else return false; // default condition.
    }
     public static void main(String[] args) 
     {
        // Build a symmetric tree:
        //        1
        //      /   \
        //     2     2
        //    / \   / \
        //   3   4 4   3

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        SymmetricTree sol = new SymmetricTree();
        boolean result = sol.isSymmetric(root);

        System.out.println("Is the tree symmetric? " + result);

        // Build an asymmetric tree:
        //        1
        //      /   \
        //     2     2
        //      \      \
        //       3      3

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2, null, new TreeNode(3));
        root2.right = new TreeNode(2, null, new TreeNode(3));

        boolean result2 = sol.isSymmetric(root2);

        System.out.println("Is the tree symmetric? " + result2);
    }
}
