public class BlockTraversal {
    public class Main {
    public static void main(String[] args) {

        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i += 2) {
            for (int j = 0; j < cols; j += 2) {

                // Top-left
                System.out.print(mat[i][j] + " ");

                // Top-right
                if (j + 1 < cols)
                    System.out.print(mat[i][j + 1] + " ");

                // Bottom-left
                if (i + 1 < rows)
                    System.out.print(mat[i + 1][j] + " ");

                // Bottom-right
                if (i + 1 < rows && j + 1 < cols)
                    System.out.print(mat[i + 1][j + 1] + " ");
            }
        }
    }
}
    
}
