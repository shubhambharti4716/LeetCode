class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combine(1, n, k);
    }
    
    private List<List<Integer>> combine(int start, int end, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if (k == 0) return ans;
        else if (start + k - 1 > end) return null;

        List<List<Integer>> rest = combine(start + 1, end, k - 1);

        if (rest != null) {
            if (rest.size() > 0) {
                for (List<Integer> item : rest) {
                    item.add(0, start);

                    ans.add(item);
                }
            } else if (k == 1) {
                ans.add(new ArrayList<>(List.of(start)));
            }
        }

        if (start + k <= end) ans.addAll(combine(start + 1, end, k));

        return ans;
    }
}