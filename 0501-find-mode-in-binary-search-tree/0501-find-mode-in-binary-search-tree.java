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
public class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> inorderr = new ArrayList<>();
        inorder(root, inorderr);

        Map<Integer, Integer> freq = new HashMap<>();
        int maxCount = 0;

        for (int val : inorderr) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            maxCount = Math.max(maxCount, freq.get(val));
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        inorder(root.left, result);
        inorder(root.right, result);
    }
}