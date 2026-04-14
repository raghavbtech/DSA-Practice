import java.util.Arrays;

public class AllocateMinimumPages {
    private static boolean isAllocationPossible(int[] pages,int k,int maxPagesAllowed){
        int currentPages=pages[0];
        int requiredStudent=1;
        for(int i=1;i<pages.length;i++){
            currentPages+=pages[i];

            if(currentPages>maxPagesAllowed){
                requiredStudent++;
                currentPages=pages[i];
            }
        }
        return requiredStudent<=k;

    }
    public static int findPages(int[] pages,int k){
        int n=pages.length;
        if(k>n)return -1;

        int maxSingleBook=pages[0];
        int totalPages=pages[0];
        for(int i=1;i<n;i++){
            maxSingleBook=Math.max(pages[i], maxSingleBook);
            totalPages+=pages[i];
        }

        int low=maxSingleBook;
        int high=totalPages;
        int answer=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isAllocationPossible(pages,k,mid)){
                answer=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return answer;
    

    }
    public static void main(String[] args) {
        
    }
}
