import java.util.*;

public class mergeSort{


public static long countInversions(List<Integer> arr) {
        int n=arr.size();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=arr.get(i);
        }
        return mergeSortA(nums,0,n-1);
        

    }
    
    private static long mergeSortA(int[] arr,int left,int right){
        long invCount=0;
        if(left<right){
            int mid=left+(right-left)/2;
            invCount+=mergeSortA(arr, left, mid);
            invCount+=mergeSortA(arr, mid+1, right);
            invCount+=merge(arr, left, mid, right);
        }
        return invCount;
    }
    
    private static long merge(int[] arr,int left,int mid,int right){
        int i=left;
        int j=mid+1;
        // int[] temp=new int[right-left+1];
        List<Integer>temp=new ArrayList<>();
        // int k=0;
        long invCount=0;
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                // temp[k++]=arr[i++];
                temp.add(arr[i]);
                i++;
            }
            else{
                // temp[k++]=arr[j++];
                temp.add(arr[j]);
                j++;
                invCount+=(mid-i+1);
            }
        }
        
        while(i<=mid){
            // temp[k++]=arr[i++];
            temp.add(arr[i]);
            i++;
        }
        while(j<=right){
            temp.add(arr[j]);
            j++;
            // temp[k++]=arr[j++];
        }
        
        for(int x=0;x<temp.size();x++){
            arr[left+x]=temp.get(x);
        }
        return invCount;
        
    }
}
