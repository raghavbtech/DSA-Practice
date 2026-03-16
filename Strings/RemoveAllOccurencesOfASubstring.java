public class RemoveAllOccurencesOfASubstring{

    //brute force
    // public static String removeOccurrences(String s, String part) {
    //     while(s.contains(part)){
    //         s=s.replace(part,"");
    //     }
    //     return s;
        
    // }


    //best

    public static String removeOccurrences(String s,String part){
        StringBuilder sb=new StringBuilder();
        int m=part.length();

        for(char c:s.toCharArray()){
            sb.append(c);
            if(sb.length()>=m && sb.substring(sb.length()-m).equals(part)){
                sb.delete(sb.length()-m, sb.length());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.println(removeOccurrences("daabc", "abc"));
        StringBuilder sb=new StringBuilder("raghav");
        System.out.println(sb.substring(2));
        sb.delete(2, 5);
        System.out.println(sb);

        
    }
}