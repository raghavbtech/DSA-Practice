import java.util.ArrayList;

public class KeyPadCombinations {
    static String[] key={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void solve(int index,String digits,String curr,ArrayList<String>ans){
        //base case
        if(index==digits.length()){
            ans.add(curr);
            return;
        }

        //recursion
        int digit=digits.charAt(index)-'0';
        String letters=key[digit];

        for(int i=0;i<letters.length();i++){
            solve(index+1, digits, curr+letters.charAt(i), ans);
        }
    }

    public static ArrayList<String> letterCombinations(String digits){
        ArrayList<String>ans=new ArrayList<>();

        if(digits.length()==0){
            return ans;
        }

        solve(0,digits,"",ans);
        return ans;
    }

}
