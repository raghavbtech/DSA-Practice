public class CountSubstrings{

    //simpple without recursion
    public static int countSameStartEndSubstrings(String s) {
    int[] freq = new int[26]; // for lowercase letters


    // count frequency of each character
    for (int i = 0; i < s.length(); i++) {
    freq[s.charAt(i) - 'a']++;
    }


    int result = 0;


    // apply k*(k+1)/2 for each character
    for (int k : freq) {
    result += (k * (k + 1)) / 2;
    }


    return result;
    }

    public static int recurSameSubStrings(String s,int i,int j,int n){
        if(n<=0)return 0;
        if(n==1)return 1;

        int res=recurSameSubStrings(s, i+1, j, n-1)+recurSameSubStrings(s, i, j-1, n-1)+recurSameSubStrings(s, i+1, j-1, n-2);

        if(s.charAt(i)==s.charAt(j)){
            res++;
        }
        return res;

    }


    
    public static void main(String[] args) {
        
    }
}