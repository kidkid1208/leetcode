/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * @author lizehui
 * @date 2021/3/25 14:58
 */
public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int loop = n / 2;
        int head = 0;
        int tail = n - 1;
        while (loop > 0) {
            //遍历top
            for (int i = head; i < tail; i++) {
                matrix[head][i] = num++;
            }
            //遍历right
            for (int i = head; i < tail; i++) {
                matrix[i][tail] = num++;
            }
            //遍历bottom
            for (int i = tail; i > head; i--) {
                matrix[tail][i] = num++;
            }
            //遍历left
            for (int i = tail; i > head; i--) {
                matrix[i][head] = num++;
            }
            loop--;
            head++;
            tail--;
        }
        if (n % 2 == 1) {
            matrix[head][tail] = num;
        }
        return matrix;
    }
}
