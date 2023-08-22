class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int a = 'A'-1;
        System.out.println(a);
        while(columnNumber >0){
            int s= columnNumber%26;
            if(s==0) {
                sb.append("Z");
                // columnNumber=columnNumber/26;
                columnNumber-= 26;
            }
            else {
            System.out.println(a+s);
                char aa = (char)(a+s);
            System.out.println(aa);
            System.out.println("----");
                sb.append(aa);
            }

            columnNumber=columnNumber/26;
            System.out.println(columnNumber);

        }
        for (int i = sb.length()-1;i>=0;i--){
            res.append(sb.charAt(i));
        }
        System.out.println(sb);
        return res.toString();
    }
}