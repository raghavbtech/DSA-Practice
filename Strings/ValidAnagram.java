import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    //Naive
    // public boolean isAnagram(String s,String t){
    //     char[] arr1=s.toCharArray();
    //     char[] arr2=s.toCharArray();
    //     Arrays.sort(arr1);
    //     Arrays.sort(arr2);
    //     return arr1.equals(arr2);
    // }

    //Better
    // public boolean isAnagram(String s,String t){
    //     int n1=s.length();
    //     int n2=t.length();

    //     if(n1!=n2)return false;

    //     HashMap<Character,Integer>m1=new HashMap<>();
    //     HashMap<Character,Integer>m2=new HashMap<>();

    //     for(char c:s.toCharArray()){
    //         m1.put(c, m1.getOrDefault(c, 0)+1);
    //     }
    //     for(char c:t.toCharArray()){
    //         m2.put(c,m2.getOrDefault(c, 0)+1);
    //     }

    //     return m1.equals(m2);

    // }

    //Best
    public boolean isAnagram(String s,String t){
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2)return false;

        int[] count=new int[26];

        for(int i=0;i<n1;i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i]!=0)return false;
        }
        return true;
    }
}
