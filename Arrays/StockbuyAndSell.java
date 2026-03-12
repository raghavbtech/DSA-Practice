// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit=0;
//         int buyed=prices[0];
//         for(int i=1;i<prices.length;i++){
//             if(buyed<prices[i]){
//                 maxProfit=Math.max(maxProfit,prices[i]-buyed);
//             }
//             else{
//                 buyed=prices[i];
//             }
//         }
//         return maxProfit;
        
//     }
// }


class Profit{
    public static int maxProfit(int[] prices){
        int maxProfit=0;
        int buyPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buyPrice){
                buyPrice=prices[i];
            }
            else{
                maxProfit=Math.max(maxProfit,prices[i]-buyPrice);
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}