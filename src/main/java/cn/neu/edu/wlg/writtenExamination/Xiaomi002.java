package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class Xiaomi002 {

        static private boolean[][] marked;
        static private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        static  private int m;
        static  private int n;
        static  private String word;
        static  private char[][] board;

        public static void main(String[] args) {

            char[][] board = {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

            Scanner scanner = new Scanner(System.in);

            String word = scanner.nextLine();
            boolean has = has(board, word);
            System.out.println(has);
        }
        public static boolean has(char[][] boards, String words) {
            m = board.length;
            if (m == 0) {
                return false;
            }
            n = board[0].length;
            marked = new boolean[m][n];
            word = words;
            board = boards;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private static boolean dfs(int i, int j, int start) {
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(start);
            }
            if (board[i][j] == word.charAt(start)) {
                marked[i][j] = true;
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (inArea(newX, newY) && !marked[newX][newY]) {
                        if (dfs(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
                marked[i][j] = false;
            }
            return false;
        }

        private static boolean inArea(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
}
