import java.util.*;

class Solution{



public int[] findMissingAndRepeatedValues(int[][] grid) {
        int size = grid.length * grid.length;
        int[] freq = new int[size+1];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                freq[grid[i][j]]++;
            }
        }

        int repeated = -1;
        int missing = -1;

        for(int i=1; i<=size; i++) {
            if(freq[i]==2) repeated = i;
            else if(freq[i] == 0) missing = i;
        }

        return new int[]{repeated,missing};
    }


}
class Practice{
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer>set=new HashSet<>();
        int n=grid.length;
        int repeated=0;
        int missing=0;
        int actualSum=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val=grid[i][j];
                actualSum+=val;
                if(set.contains(val)){
                    repeated=val;
                }
                set.add(val);
            }
        }

        int expectedSum=((n*n)*(n*n+1))/2;
        missing=expectedSum+repeated-actualSum;
        return new int[]{repeated,missing};
        // actualSum=expectedSum-missing+repeated;
        // missing=expectedSum+repeated-actualSum
    }
}