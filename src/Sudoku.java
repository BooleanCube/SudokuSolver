import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Sudoku {

    public final static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            String line = bf.readLine();
            for(int j=0; j<line.length(); j++) {
                if(line.charAt(j) == '_') board[i][j] = 0;
                else {
                    try {
                        board[i][j] = Integer.parseInt(line.substring(j, j+1));
                        if(board[i][j] > 9 && board[i][j] < 1) {
                            System.out.println("Error: Wrong Input Format...\nUse numbers between 1-9 and under_scores!");
                            return;
                        }
                    } catch(NumberFormatException nfe) {
                        System.out.println("Error: Wrong Input Format...\nUse numbers between 1-9 and under_scores!");
                        return;
                    }
                }
            }
        }
        int[][] solved = Solver.solvePuzzle();
        if(solved == null) {
            System.out.println("Unsolvable Sudoku Puzzle!");
            return;
        }
        for(int[] i : solved)
            System.out.println(Arrays.toString(i));
    }

}
