import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ZigZagTree
{
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    levelList.addLast(node.val); // Append at the end
                } else {
                    levelList.addFirst(node.val); // Insert at the front
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(levelList);
            leftToRight = !leftToRight; // Toggle direction
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagTree tree = new ZigZagTree();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println(tree.zigzagLevelOrder(root));
    }
}
