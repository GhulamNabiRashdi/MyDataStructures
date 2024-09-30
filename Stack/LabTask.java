import java.util.Stack;

public class LabTask {
    
    public boolean isBalancedBracket(String brackets){
        Stack<Character> list = new Stack<>();
        for(int i = 0; i < brackets.length(); i++){
            if(brackets.charAt(i) == '(' || brackets.charAt(i) == '{' || brackets.charAt(i) == '[')
            list.push(brackets.charAt(i));

            else if(brackets.charAt(i) == ')' || brackets.charAt(i) == '}' || brackets.charAt(i) == ']') 
            {
                if (list.isEmpty()) return false;

                if(brackets.charAt(i) == ')' && list.peek() == '('){
                    list.pop();
                }

                else if(brackets.charAt(i) == '}' && list.peek() == '{'){
                    list.pop();
                }
                else if(brackets.charAt(i) == ']' && list.peek() == '['){
                    list.pop();
                }
                else{
                    return false;
                }
                
            }
        }
            return list.isEmpty();
        }
        

}
