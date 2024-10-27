import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                s1.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']' && !s1.isEmpty()){
                if(s1.peek() == '(' && s.charAt(i) == ')'){
                    s1.pop();
                }
                else if(s1.peek() == '{' && s.charAt(i) == '}'){
                    s1.pop();
                }
                else if(s1.peek() == '[' && s.charAt(i) == ']'){
                    s1.pop();
                }
                else{
                    return false;
                }

            }
        }
        return s1.isEmpty();
    }
}

