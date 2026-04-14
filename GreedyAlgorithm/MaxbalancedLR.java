public class MaxbalancedLR {
    public static int maxBalanced(String s){
        int balance=0;
        int count=0;

        for(char c:s.toCharArray()){
            if(c=='L')balance++;
            else balance--;
            if(balance==0)count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String s="LRRRRLLRLLRL";
        System.out.println(maxBalanced(s));

    }
}
