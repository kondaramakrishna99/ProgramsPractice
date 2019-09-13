public class WordAbbr_leetcode408 {

    public boolean validWordAbbreviation(String word, String abbr) {
        if((word == null && abbr == null) || (word.length()==0 && abbr.length()==0))
            return true;
        if((word == null || abbr == null) || (word.length()==0 || abbr.length()==0) || abbr.length()>word.length())
            return false;

        int i = -1;
        int num = 0;
        int j=0;
        for(j = 0; j<abbr.length();j++) {
            char curr = abbr.charAt(j);

            if(Character.isDigit(curr)) {
                num = num*10 + Character.getNumericValue(curr);
                continue;
            }

            if(Character.isLetter(curr)) {
                i = i+num+1;
                if(i>=word.length() || word.charAt(i) != curr) {
                    return false;
                }
                num = 0;
            }
        }
        i = i+num+1;
        if (i == word.length() && j==abbr.length())
            return true;
        return false;
    }
}
