public class LongestHappyPrefix {
    public String longestPrefix(String s){
        int n=s.length();
        int[] lps=new int[n];

        int len=0,i=1;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[n-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return s.substring(0,lps[n-1]);
    }

    //bruet force
    // public String longestPrefix(String s){
    //     int n=s.length();
    //     for(int len=n-1;len>0;len--){
    //         String prefix=s.substring(0,len);
    //         String suffix=s.substring(n-len);
    //         if(prefix.equals(suffix)){
    //             return  prefix;
    //         }
    //     }
    //     return "";
    // }
    public static void main(String[] args) {
        
    }
}
