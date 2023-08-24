class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new ArrayList<>();

        int wordsPerLine = 0;    
        int lineLength = 0;    

        for (int i = 0; i < words.length; i++) {
            
           if(lineLength + words[i].length() + wordsPerLine >  maxWidth) {
                if(wordsPerLine != 0) { 

                    String line = ""; 
                    int remSpaces = maxWidth - lineLength;

                    int max = Math.max(wordsPerLine - 1, 1);
                    int count = remSpaces / max;
                    int extra = remSpaces % max;

                    for (int j = i - wordsPerLine; j < i; j++) {

                        int nSpaces = Math.min(count, remSpaces) + (extra-- > 0 ? 1 : 0);
                        line += words[j] += " ".repeat(nSpaces); 

                        remSpaces -= nSpaces;
                    }

                    r.add(line); 
                }   

                wordsPerLine = 0;
                lineLength = 0;
           }

           wordsPerLine++;
           lineLength += words[i].length();
         
            if(i == words.length - 1) {
                String line = ""; 
                for (int j = words.length - wordsPerLine; j < words.length; j++) {
                    line += words[j]; 

                    if(j != words.length - 1) line+= " ";
                }

                line += " ".repeat(maxWidth - line.length());
                r.add(line);   
            } 
        }

        

        return r; 
        
    }
}