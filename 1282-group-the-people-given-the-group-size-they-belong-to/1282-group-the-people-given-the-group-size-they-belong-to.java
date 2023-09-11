class Solution {
    boolean[] groupFlag;

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        groupFlag = new boolean[groupSizes.length];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0;i < groupSizes.length;i++) {
            if (!groupFlag[i]) {
                res.add(findNumIndex(groupSizes, groupSizes[i], i));
            }
        }
        return res;
    }

    public List<Integer> findNumIndex(int[] a, int x, int index) {
        List<Integer> res = new ArrayList<>();
        int k = 0;
        for (int i = index;i < a.length;i++) {
            if (k == x) {
                return res;
            }
            if (a[i] == x) {
                res.add(i);
                groupFlag[i] = true;
                k++;
            }
        }
        return res;
    }
}