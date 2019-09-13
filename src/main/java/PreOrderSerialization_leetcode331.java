import java.util.Stack;

public class PreOrderSerialization_leetcode331 {

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,"));
    }

    public static boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for(int i=0;i<array.length;i++) {
            String str = array[i];
            if (!str.equalsIgnoreCase("#")) {
                stack.push(str);
            } else {
                if(stack.isEmpty()) {
                    stack.push(str);
                } else {
                    String peek = stack.peek();
                    if (!peek.equalsIgnoreCase("#")) {
                        stack.push(str);
                    } else {
                        while(!stack.isEmpty() && stack.peek().equals("#")) {
                            stack.pop();
                            if(stack.isEmpty())
                                return false;
                            stack.pop();
                        }
                        stack.push("#");
                    }
                }
            }
        }

        return stack.size() == 1 && stack.peek().equals("#");

    }

}
