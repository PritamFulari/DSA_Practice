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


//

// Pre Order Traverse

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
  // Stack<TreeNode> stack = new Stack<>();  Deque is used as it's more efficient than stack in java

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
        if (p != null) {
            stack.push(p);
            result.add(p.val);  // Add before going to children
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            p = node.right;   
        }
    }
    return result;
}

// In Order Traverse

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
        if (p != null) {
            stack.push(p);
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            result.add(node.val);  // Add after all left children
            p = node.right;   
        }
    }
    return result;
}

// Post Order Traverse

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while (p != null || !stack.isEmpty()) {
        if (p != null) {
            result.add(p.val);  // Add before going to children
            stack.push(p);
            p = p.right;
        } else {
            p = stack.pop();
            p = p.left;
        }
    }
    Collections.reverse(result);
    return result;
}
