class Solution {

  int min;

  public int minimumEffortPath(int[][] heights) {
    int m = heights.length, n = heights[0].length;
    int lo = 0, hi = 1_000_000;
    while (lo < hi) {
      int mi = (hi + lo) / 2;
      if (underDiff(heights, 0, 0, mi, new boolean[m][n])) {
        hi = mi;
      } else {
        lo = mi + 1;
      }
    }
    return lo;
  }

  // check whether A has a path which effort is <= maxdiff
  // if found one, return true
  // if all possibility has tried, return false
  private boolean underDiff(
    int[][] A,
    int i,
    int j,
    int maxdiff,
    boolean[][] visited
  ) {
    int m = A.length, n = A[0].length;
    if (i == m - 1 && j == n - 1) {
      return true;
    }
    int height = A[i][j];
    visited[i][j] = true;
    if (
      i + 1 < m &&
      !visited[i + 1][j] &&
      Math.abs(A[i + 1][j] - height) <= maxdiff
    ) {
      if (underDiff(A, i + 1, j, maxdiff, visited)) {
        return true;
      }
    }
    if (
      j + 1 < n &&
      !visited[i][j + 1] &&
      Math.abs(A[i][j + 1] - height) <= maxdiff
    ) {
      if (underDiff(A, i, j + 1, maxdiff, visited)) {
        return true;
      }
    }
    if (
      i - 1 >= 0 &&
      !visited[i - 1][j] &&
      Math.abs(A[i - 1][j] - height) <= maxdiff
    ) {
      if (underDiff(A, i - 1, j, maxdiff, visited)) {
        return true;
      }
    }
    if (
      j - 1 >= 0 &&
      !visited[i][j - 1] &&
      Math.abs(A[i][j - 1] - height) <= maxdiff
    ) {
      return underDiff(A, i, j - 1, maxdiff, visited);
    }
    return false;
  }
}