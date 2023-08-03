class Solution {
      static String[] keyPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static void result(List <String> res, int num, String ans){
        if(num == 0){
            res.add(ans);
        }
        int n = num % 10;
        String key = keyPad[n];
        for(int i = 0; i < key.length(); i++){
            result(res,num / 10, key.charAt(i) + ans);
        }
    }

    public List<String> letterCombinations(String digits) {
       List <String> res = new ArrayList<String> ();
        if(digits.length() == 0){
            return res;
        }
        int num = Integer.parseInt(digits);
        result(res,num , "");
        return res;

    }
}