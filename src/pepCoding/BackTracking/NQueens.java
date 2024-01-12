package pepCoding.BackTracking;

public class NQueens {
    public static void main(String[] args) {
        int [][] chess = new int[4][4];
        printNQueen(chess,"",0);
    }

    private static void printNQueen(int[][] chess, String qsf, int row) {
        if(row == chess.length){
            System.out.println(qsf);
            return;
        }

        for(int col = 0; col < chess.length; col++){
            if(isItSafeForQueen(chess, row, col)){
                chess[row][col] = 1;
                printNQueen(chess, qsf + row + " - " + col + ", ",row+1);
                chess[row][col] = 0;
            }
        }

    }

    private static boolean isItSafeForQueen(int[][] chess, int row, int col) {
        for(int i = row-1, j = col; i >= 0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i = row-1, j = col+1; i >= 0 && j < chess.length; i++, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}
