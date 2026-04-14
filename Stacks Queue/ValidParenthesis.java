import java.util.Stack;

public class ValidParenthesis {
    class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }
            else if(c==')' || c=='}' || c==']'){
                if(st.isEmpty())return false;
                if((c==')' && st.peek()!='(') || (c==']' && st.peek()!='[') || (c=='}' && st.peek()!='{')){
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
        
    }
}
}
