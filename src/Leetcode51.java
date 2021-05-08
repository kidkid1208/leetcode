import java.util.ArrayList;
import java.util.List;

/**
 * @author lizehui
 * @date 2021/5/8 15:45
 */
public class Leetcode51 {
    private List<List<String>> result = new ArrayList<>();

    private char[][] solution;

    public List<List<String>> solveNQueens(int n) {
        solution = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solution[i][j] = '.';
            }
        }
        backTracking(0, n);
        return result;
    }

    private void backTracking(int index, int n) {
        if (index == n) {
            List<String> s = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                s.add(new String(solution[i]));
            }
            result.add(s);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canPut(index, i, n)) {
                solution[index][i] = 'Q';
                backTracking(index + 1, n);
                solution[index][i] = '.';
            }
        }
    }

    private boolean canPut(int r, int c, int n) {
        for (int i = 0; i < r; i++) {
            if (solution[i][c] == 'Q') {
                return false;
            }
        }
        int i = 1;
        while (r - i >= 0 && c - i >= 0) {
            if (solution[r - i][c - i] == 'Q') {
                return false;
            }
            i++;
        }
        int j = 1;
        while (r - j >= 0 && c + j < n) {
            if (solution[r - i][c + j] == 'Q') {
                return false;
            }
            j++;
        }
        return true;
    }
}
