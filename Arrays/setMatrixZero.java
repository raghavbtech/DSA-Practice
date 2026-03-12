class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zeroInfirstcol=false;
        for(int row=0;row<matrix.length;row++){
            if(matrix[row][0]==0)zeroInfirstcol=true;
            for(int col=1;col<matrix[0].length;col++){
                if(matrix[row][col]==0){
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }


        }

        for(int row=matrix.length-1;row>=0;row--){
            for(int col=matrix[0].length-1;col>=1;col--){
                if(matrix[row][0]==0 || matrix[0][col]==0){
                    matrix[row][col]=0;

                }
            }
            if(zeroInfirstcol){
                matrix[row][0]=0;
        }
        }
        
        
    }
}



class Practice{
    public void setZeros(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        boolean zeroInfirstcol=false;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0)zeroInfirstcol=true;
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }


        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }

            if(zeroInfirstcol){
                matrix[i][0]=0;
            }
        }

    }
}