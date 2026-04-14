import java.util.PriorityQueue;

public class ConnectNropeswithMinimumCost {
    public static int minCost(int[] arr){
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int totalcost=0;
        
        for (int x : arr) {
        pq.add(x);
    }

        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();

            int cost = a + b;
             totalcost += cost;

        pq.add(cost);
        }
        return totalcost;
    } 
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};
        System.out.println(minCost(arr));
    }
}
