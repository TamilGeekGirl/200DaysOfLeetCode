public class SameTree
{
    
    public boolean isSameTree(TreeNode p, TreeNode q) 
    { 
        if (p == null && q == null) 
        { 
            return true; 
        } 
        if (p == null || q == null) 
        { 
            return false; 
        } 
        
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    } 
    public static void main(String[] args) 
    {
        SameTree solution = new SameTree();

        // Example 1: Trees are the same
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Example 1 Output: " + solution.isSameTree(p1, q1)); // true


        // Example 2: Trees are different
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.left = new TreeNode(2);
        q2.right = new TreeNode(3);

        System.out.println("Example 2 Output: " + solution.isSameTree(p2, q2)); // false
    }
    
}
