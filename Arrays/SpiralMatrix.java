import java.util.*;;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0,right=matrix[0].length-1;
        int top=0,bottom=matrix.length-1;
        List<Integer>ans=new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int j=top;j<=bottom;j++){
                ans.add(matrix[j][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int j=bottom;j>=top;j--){
                    ans.add(matrix[j][left]);
                }
                left++;
            }
        }
        return ans;
        
    }
}


class Practice{
    public static List<Integer>spiralOrder(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int left=0,right=matrix[0].length-1;
        int top=0,bottom=matrix.length-1;
        List<Integer>ans=new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int j=top;j<=bottom;j++){
                ans.add(matrix[j][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int j=bottom;j>=top;j--){
                    ans.add(matrix[j][left]);
                }
                left++;
            }
        }
        return ans;

    }
}