import java.util.ArrayList;
import java.util.List;

public class TextJustification_leetcode68 {

    public static void main(String[] args) {
        List<String> result = fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                        "to","a","computer.","Art ","is","everything","else","we","do"}, 20);
        for(String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        int startIndex=0;
        int endIndex;
        int presWidth=0;
        int numOfWords;
        List<String> result = new ArrayList<>();
        int numOfEvenSpaces;

        for(int i=0;i<words.length;i++) {
            if(presWidth+words[i].length()+(i-startIndex)<=maxWidth) {
                presWidth+=words[i].length();
            } else  {
                endIndex = i-1;
                numOfWords = endIndex - startIndex +1;
                numOfEvenSpaces = numOfWords==1? (maxWidth - presWidth): (maxWidth - presWidth)/(numOfWords-1);
                int remSpaces = numOfWords==1?0:(maxWidth - presWidth)%(numOfWords-1);
                String str= "";
                for (int j=startIndex;j<=endIndex;j++) {
                    str+=words[j];
                    for(int k=0;str.length()<maxWidth && k<numOfEvenSpaces;k++) {
                        str+=" ";
                    }
                    if(remSpaces>0) {
                        str+=" ";
                        remSpaces--;
                    }
                }
                result.add(str);
                startIndex = i;
                presWidth = words[i].length();
            }
        }

        if(presWidth>0) {
            String str = "";
            for(int i= startIndex;i<words.length;i++) {
                str+=words[i];
                if(str.length()<maxWidth)
                    str+=" ";
            }
            int remainingSpaces = maxWidth-str.length();
            for(int i=0;i<remainingSpaces;i++) {
                str+=" ";
            }
            result.add(str);
        }

        return result;
    }
}
