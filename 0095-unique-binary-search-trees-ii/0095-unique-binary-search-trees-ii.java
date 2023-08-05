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
  Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();

  private List<TreeNode> generateTrees(int l, int r) {
    if (l > r)
      return new ArrayList<>() {{add(null);}};

    var list = new ArrayList<TreeNode>();
    var pair = new Pair(l, r);

    if (memo.containsKey(pair))
      return memo.get(pair);
  
    for (var i=l; i<=r; i++)
      for (var left : generateTrees(l, i-1))
        for (var right : generateTrees(i+1, r))
          list.add(new TreeNode(i, left, right));
    
    memo.put(pair, list);
    return list;
  }

  public List<TreeNode> generateTrees(int n) {
    return generateTrees(1, n);
  }
}