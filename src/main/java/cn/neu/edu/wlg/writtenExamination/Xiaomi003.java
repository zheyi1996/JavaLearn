package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

class Solution {

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
    public static boolean has(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 ) {
            return false;
        }
        if(word.length() == 0 || null == word) {
            return false;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int cur) {
        if(cur == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(cur)) {
            return false;
        }
        char c = board[i][j];
        //改变一下搜索过的地儿的状态，避免重复搜索
        board[i][j] = '.';
        boolean ret1 = dfs(board, i + 1, j, word, cur + 1);
        boolean ret2 = dfs(board, i - 1, j, word, cur + 1);
        boolean ret3 = dfs(board, i, j + 1, word, cur + 1);
        boolean ret4 = dfs(board, i, j - 1, word, cur + 1);
        //对于这个分支的DFS已经完成了，需要回溯还原现场
        board[i][j] = c;
        return ret1 || ret2 || ret3 || ret4;
    }
}