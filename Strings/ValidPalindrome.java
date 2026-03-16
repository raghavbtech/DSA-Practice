public class ValidPalindrome{

    //Brute Force
    // public boolean isPalindrome(String s){
    //     int n=s.length();

    //     String str1="";
    //     for(char c:s.toCharArray()){
    //         if(Character.isLetterOrDigit(c)){
    //             str1+=c;
    //         }
    //     }
    //     String str2=str1;
    //     StringBuilder sb=new StringBuilder(str1);
    //     str1=sb.reverse().toString();

    //     return str1.equals(str2);
    // }


    //Best
    
    public boolean isPalindrome(String s){
        int n=s.length();

        int low=0;
        int high=n-1;

        while(low<=high){
            if(!Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(high))){
                high--;
            }
            else if(Character.toLowerCase(s.charAt(low))==Character.toLowerCase(s.charAt(high))){
                low++;
                high--;
            }
            else{
                return false;
            }
        }
        return true;
    }

}