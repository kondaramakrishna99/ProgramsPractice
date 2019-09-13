import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath_leetcode71 {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/.."));
    }

    public static String simplifyPath(String path) {

        String[] words = path.split("/");
        System.out.println(Arrays.toString(words));
        Stack<String> stack = new Stack<>();
        for(int i=1;i<words.length;i++) {
            if(words[i].equals(".") || words[i].equals(""))
                continue;
            if(words[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(words[i]);
            }
        }

        System.out.println(stack.toString());

        String result = "";

        while(!stack.isEmpty()) {
            result+="/"+stack.pop();
        }

        System.out.println(result);
        return result==""?"/":result;
    }
}
