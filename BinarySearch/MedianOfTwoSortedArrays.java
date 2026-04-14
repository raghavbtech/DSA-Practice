public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        int n1=nums1.length;
        int n2=nums2.length;
        int totalLength=n1+n2;

        int i=0,j=0,count=0;
        int prev=0,curr=0;
        while(count<=totalLength/2){
            prev=curr;
            if(i<n1 && (j>=n2 || nums1[i]<nums2[j])){
                curr=nums1[i++];
            }
            else{
                curr=nums2[j++];
            }
            count++;
        }
        if(totalLength%2==0){
            return (prev+curr)/2;
        }
        else{
            return curr;
        }

    }    
}
