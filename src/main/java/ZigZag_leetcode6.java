import java.util.ArrayList;
import java.util.List;

public class ZigZag_leetcode6 {

    public static void main(String[] args) {
        convert1("PAYPALISHIRING", 3);
    }

    public static String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static String convert(String s, int numRows) {
        List<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
        for(int i=0; i<numRows;i++) {
            list.add(new ArrayList<>());
        }
        boolean reverse = false;
        int j=0;
        for(int i=0; i<s.length(); i++) {
            list.get(j).add(s.charAt(i));
            if(j==numRows-1) {
                reverse = true;
            } else if(j==0) {
                reverse = false;
            }

            if(!reverse) {
                j++;
            } else {
                j--;
            }
        }
        String result ="";
        for(int i=0; i<numRows;i++) {
            for(j=0;j<list.get(i).size();j++) {
                result = result+list.get(i).get(j);
            }
        }
        System.out.println(result +" "+list.toString());
        StringBuilder str = new StringBuilder("abcd");
        return list.toString();
    }

}
