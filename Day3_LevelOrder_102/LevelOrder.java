import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Write a description of class LevelOrder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LevelOrder
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
    public static void main(String[] args) 
    {
        // Build a sample tree:
        //        1
        //      /   \
        //     2     3
        //    / \   / \
        //   4   5 6   7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.right = new TreeNode(3, new TreeNode(6), new TreeNode(7));

        LevelOrder sol = new LevelOrder();
        List<List<Integer>> result = sol.levelOrder(root);

        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
