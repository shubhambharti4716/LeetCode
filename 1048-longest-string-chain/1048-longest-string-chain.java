
class Solution {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> wordsSet = new HashSet<>(words.length);
        boolean[] length = new boolean[17];
        for (String word : words) {
            wordsSet.add(word.hashCode());
            length[word.length()] = true;
        }

        int ptr = words.length - 1;
        int max = 1;
        while (ptr >= 0) {
            int value = map.getOrDefault(words[ptr].hashCode(), 0) + 1;
            max = Math.max(max, value);

            if (words[ptr].length() > 1 && length[words[ptr].length() - 1]) {
                for (int i = 0; i < words[ptr].length(); i++) {
                    int h = 0;
                    for (int j = 0; j < words[ptr].length(); j++) {
                        if (j != i) {
                            h = 31 * h + (words[ptr].charAt(j) & 0xff);
                        }
                    }

                    if (wordsSet.contains(h)) {
                        map.merge(h, value, Math::max);
                    }
                }
            }
            ptr--;
        }

        return max;
    }
}