public class FindSubsetsOfString {
    public static void findSubsets(String str,String ans,int i){
        //base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }
            else{

                System.out.println(ans);
            }
            return;
        }
        //kaam
        //choices

        //yes
        findSubsets(str, ans+str.charAt(i), i+1);

        //no
        findSubsets(str, ans, i+1);

    }
    public static void main(String[] args) {
        
    }
}
