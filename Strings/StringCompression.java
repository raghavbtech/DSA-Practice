import java.util.*;

public class StringCompression {
    public static int compress(char[]  chars){
        int write=0; // position to write
        int read=0; // position to read
        int n=chars.length;

        while(read<n){
            char curr=chars[read];
            int count=0;

            while(read<n && chars[read]==curr){
                read++;
                count++;
            }
            chars[write++]=curr;

            if(count>1){
                for(char c:String.valueOf(count).toCharArray()){
                    chars[write++]=c;
                }
            }
        }
        return write;
    }
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));


        
    }
}
