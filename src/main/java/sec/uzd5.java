package sec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uzd5 {

    private static int[][] sudoku = new int[4][4];

    public static void main(String[] args) throws IOException {

        String[] str;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            for (int i = 0; i < 4; i++) {
                System.out.print("Line " + (i + 1) + " : ");
                str = br.readLine().split("\\s");
                //str = args[i].split("\\s"); // jUnit test

                if (str.length != 4)
                    throw new IllegalArgumentException();

                for (int j = 0; j < str.length; j++) {
                    sudoku[i][j] = Integer.parseInt(str[j]);
                    if (sudoku[i][j] < 0 || sudoku[i][j] > 4)
                        throw new IllegalArgumentException();
                }

            }

        } catch (IllegalArgumentException e) {
            System.out.println("Input error");
            return;
        }

        if (!solve()) {
            System.out.println("\n¯\\_(ツ)_/¯");
        } else {
            System.out.println();
            for (int[] i : sudoku) {
                for (int j : i) {
                    System.out.print(j + "\t");
                }
                System.out.println();
            }
        }
    }

    private static boolean solve() {
        int i = 0, j = 0;
        boolean empty = false;

        for (int n = 0; n < sudoku.length && !empty; n++)
            for (int m = 0; m < sudoku.length && !empty; m++) {
                if (sudoku[n][m] == 0) {
                    empty = true;
                    i = n;
                    j = m;
                }
            }

        if (!empty) return true;

        for (int x = 1; x <= 4; x++) {
            if (putX(i, j, x)) {
                sudoku[i][j] = x;
                if (solve()) return true;
                sudoku[i][j] = 0;
            }
        }

        return false;
    }

    private static boolean putX(int i, int j, int x) {

        for (int[] iSudoku : sudoku)
            if (iSudoku[j] == x) return false;

        for (int n = 0; n < sudoku[i].length; n++)
            if (sudoku[i][n] == x) return false;

        for (int n = 0; n < 2; n++)
            for (int m = 0; m < 2; m++)
                if (sudoku[(i - i % 2) + n][(j - j % 2) + m] == x)
                    return false;

        return true;
    }
}
