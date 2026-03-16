import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {
    //Better
    // public String reverseWords(String s){
    //     List<String>words=new ArrayList<>();
    //     StringBuilder word=new StringBuilder();

    //     for(char c:s.toCharArray()){
    //         if(c!=' '){
    //             word.append(c);
    //         }
    //         else{
    //             words.add(word.toString());
    //             word.setLength(0);
    //         }
    //     }

    //     if(word.length()>0){
    //         words.add(word.toString());
    //     }

    //     Collections.reverse(words);

    //     return String.join(" ",words);
    // }


    //Best
    public String reverseWords(String s){
        String ans="";
        String word="";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ' && !word.equals("")){
                ans=word+" "+ans;
                word="";
            }
            else if(s.charAt(i)==' ')continue;
            else{
                word+=s.charAt(i);
            }
        }

        if(!word.equals("")){
            ans=word+" "+ans;
        }
        return ans.trim();
    }
}
