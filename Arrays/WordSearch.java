public class WordSearch {
    public boolean exist(char[][] board,String word){
        int n=board.length;
        int m=board[0].length;
        int size=word.length();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(i, j, board, word, 1, n, m, size)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private int[] r={-1,1,0,0};
    private int[] c={0,0,-1,1};
    private boolean helper(int row,int col,char[][] board,String word,int index,int n,int m,int size){
        if(index==size){
            return true;
        }
        char temp=board[row][col];
        board[row][col]='#';
        for(int i=0;i<4;i++){
            int nr=row+r[i];
            int nc=col+c[i];

            if(nr>=0 && nr<n && nc>=0 && nc>m){
                if(board[nr][nc]==word.charAt(index)){
                    if(helper(nr, nc, board, word, index+1,n, m, size)){
                        return true;
                    }
                }
            }
        }

        board[row][col]=temp;
        return false;
    }
    public static void main(String[] args) {
        
    }
}
