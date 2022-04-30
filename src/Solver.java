import java.util.ArrayList;
import java.util.Arrays;

public class Solver {

    private static boolean isSolved(int[][] board) {
        for(int[] i : board)
            for(int j : i)
                if(j == 0) return false;
        return true;
    }

    public static ArrayList<Integer> getPossible(int[][] board, int x, int y) {
        ArrayList<Integer> possibilities = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int qx=0, qy=0;
        if(x>=6) qx=6; else if(x>=3) qx=3;
        if(y>=6) qy=6; else if(y>=3) qy=3;
        for(int i=qx; i<qx+3; i++)
            for(int j=qy; j<qy+3; j++)
                possibilities.remove(Integer.valueOf(board[i][j]));
        for(int i=0; i<9; i++)
            possibilities.remove(Integer.valueOf(board[i][y]));
        for(int i=0; i<9; i++)
            possibilities.remove(Integer.valueOf(board[x][i]));
        return possibilities;
    }

    public static int[][] solvePuzzle() {
        int[][] board = Sudoku.board;
        while(!isSolved(board)) {
            boolean checkLoop = true;
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    if(board[i][j] == 0) {
                        ArrayList<Integer> possible = getPossible(board, i, j);
                        if(possible.size() == 1) {
                            board[i][j] = possible.get(0);
                            checkLoop = false;
                        }
                    }
                }
            }
            if(checkLoop) return null;
        }
        return board;
    }

}
