import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingInAStream {
    public static void nonRepeat(String s){
        int[] freq=new int[26];
        Queue<Character>q=new LinkedList<>();

        for(char c:s.toCharArray()){
            q.add(c);
            freq[c-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.poll();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print((q.peek())+" ");
            }
        }
    }
    public static void main(String[] args) {
        nonRepeat("aabccxb");
    }
}
