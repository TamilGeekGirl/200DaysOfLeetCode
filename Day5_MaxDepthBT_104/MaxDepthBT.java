
/**
 * Write a description of class MaxDepthBT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MaxDepthBT
{
    public int maxDepth(TreeNode root) 
    { 
        if (root == null) 
        { 
            return 0; 
        } 
        
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right)); 
}
     public static void main(String[] args) {
        // Build tree:
        //        1
        //      /   \
        //     2     3
        //    / \
        //   4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3);

        MaxDepthBT sol = new MaxDepthBT();
        int depth = sol.maxDepth(root);
        System.out.println("Max Depth of Tree: " + depth); // Expected: 3

        // Another test: skewed tree
        //   1
        //    \
        //     2
        //      \
        //       3
        TreeNode skewed = new TreeNode(1);
        skewed.right = new TreeNode(2);
        skewed.right.right = new TreeNode(3);

        System.out.println("Max Depth of Skewed Tree: " + sol.maxDepth(skewed)); // Expected: 3
    }
}
