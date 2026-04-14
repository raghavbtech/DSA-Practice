public class NumberToString {
    static String[] str={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void printDigits(int num){
        if(num==0){
            return;
        }

        int lastDigit=num%10;
        printDigits(num/10);
        System.out.print(str[lastDigit]+" ");
        
    }
    public static void main(String[] args) {
        

    }
    
}
