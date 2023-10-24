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
class Solution {
    public List<Integer> largestValues(TreeNode root) {
       Map <Integer , Integer> map = new HashMap(); 
       dfs(root, 0, map);
       return new ArrayList(map.values());
    }

    private void dfs(TreeNode root, int level, Map<Integer , Integer> map){
        if(root==null) return;

        map.put(level, Math.max(root.val, map.getOrDefault(level, Integer.MIN_VALUE)));
        dfs(root.left, level+1, map);
        dfs(root.right, level+1, map);
    }
}