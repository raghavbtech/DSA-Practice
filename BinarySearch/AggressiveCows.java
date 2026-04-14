import java.util.Arrays;

public class AggressiveCows {
    private boolean isValid(int[] stalls,int cows,int minDistance){
        int totalStalls=stalls.length;
        int lastPlacedIndex=0;
        int cowsPlaced=1;

        for(int currentIndex=1;currentIndex<totalStalls && cowsPlaced<cows;currentIndex++){
            if(stalls[currentIndex]-stalls[lastPlacedIndex]>=minDistance){
                cowsPlaced++;
                lastPlacedIndex=currentIndex;
            }
        }
        return cows==cowsPlaced;

    }

    public int aggressiveCows(int[] stalls,int cows){
        Arrays.sort(stalls);
        int totalStalls=stalls.length;

        int low=1;
        int high=stalls[totalStalls-1]-stalls[0];
        int maxMinDistance=1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(stalls,cows,mid)){
                maxMinDistance=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return maxMinDistance;
    }
}
