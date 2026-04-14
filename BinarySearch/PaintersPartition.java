import java.util.*;

public class PaintersPartition {
    private static boolean isValid(int[] arr,int painters,int maxTime){
        int workers=1;
        int time=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxTime)return false;
            time+=arr[i];
            if(time>maxTime){
                workers++;
                time=arr[i];
            }
        }
        return workers<=painters;
    }
    public static int minTime(int[] arr,int k){
        int boards=arr.length;
        int maxVal=arr[0];
        int totalSum=arr[0];

        for(int i=1;i<boards;i++){
            maxVal=Math.max(maxVal, arr[i]);
            totalSum+=arr[i];
        }

        int low=maxVal;
        int high=totalSum;
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(arr,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] arr={10,5,20,15,25};
        int k=2;
        System.out.println(minTime(arr, k));

        
    }
}
