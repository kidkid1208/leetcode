/**
 * @author lizehui
 * @date 2021/5/8 16:19
 */
public class Leetcode37 {
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        backTracking(0);
    }

    private boolean backTracking(int n) {
        if (n == 81) {
            return true;
        }
        int i = n / 9;
        int j = n % 9;
        if (board[i][j] != '.') {
            return backTracking(n + 1);
        }
        for (char k = '1'; k <= '9'; k++) {     // (i, j) 这个位置放k是否合适
            if (isValid(i, j, k)) {
                board[i][j] = k;                // 放置k
                if (backTracking(n + 1)) {
                    return true; // 如果找到合适一组立刻返回
                }
                board[i][j] = '.';              // 回溯，撤销k
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int val) {
        for (int i = 0; i < 9; i++) { // 判断行里是否重复
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) { // 判断列里是否重复
            if (board[j][col] == val) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) { // 判断9方格里是否重复
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
