import java.util.Stack;

public class SimplifyPath {
    class Solution {
    public String simplifyPath(String path) {
        String[] parts=path.split("/");
        Stack<String> st = new Stack<>();
        for(String p:parts){
            if(p.equals(".") || p.equals(""))continue;
            if(p.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(p);
            }
        }

        StringBuilder sb=new StringBuilder("");
        for(String b:st){
            sb.append("/").append(b);
        }

        return sb.length()==0?"/":sb.toString();
        
    }
}
    
}
