import java.util.Stack;

public class SortedStack {
    // class Solution {
    // public void sortStack(Stack<Integer> st) {
    //     if(st.isEmpty())return;
        
    //     int top=st.pop();
    //     sortStack(st);
    //     insertSorted(st,top);
    // }
    
    // public void insertSorted(Stack<Integer>st,int val){
    //     if(st.isEmpty() || st.peek()<=val){
    //         st.push(val);
    //         return;
    //     }
        
    //     int top=st.pop();
    //     insertSorted(st,val);
    //     st.push(top);
    // }
// }

    static Stack<Integer> sortStack(Stack<Integer>st){
        Stack<Integer>temp=new Stack<>();

        while(!st.isEmpty()){
            int curr=st.pop();

            while(!temp.isEmpty() && temp.peek()>curr){
                st.push(temp.pop());
            }

            temp.push(curr);
        }
        return temp;
    }
}
