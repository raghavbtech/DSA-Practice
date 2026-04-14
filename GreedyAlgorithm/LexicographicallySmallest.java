import java.util.Arrays;

public class LexicographicallySmallest {
    static String smallestString(int N,int K){
        char[] res=new char[N];
        Arrays.fill(res,'a');
        int extra=K-N;
        for(int i=N-1;i>=0 && extra>0;i--){
            int add=Math.min(25,extra);
            res[i]=(char)(res[i]+add);
            extra-=add;
        }

        return new String(res);
    }
    public static void main(String[] args) {
        System.out.println(smallestString(5, 42));
    }
}
