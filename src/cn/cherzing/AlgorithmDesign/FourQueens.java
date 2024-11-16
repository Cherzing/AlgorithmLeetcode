package cn.cherzing.AlgorithmDesign;

/**
 * @author Cherzing
 * @date 2024/11/28 0028 11:21
 * @description EightQueens
 */
public class FourQueens {
    private int[] queens; // 存储皇后的位置，queens[i]表示第i行的皇后所在的列

    public FourQueens() {
        queens = new int[4];
    }

    public void solve() {
        placeQueen(0);
    }

    /**
     * 剪枝并放置皇后
     * @param row
     */
    private void placeQueen(int row) {
        if (row == 4) { // 所有皇后都已放置
            printSolution();
            return;
        }
        for (int col = 0; col < 4; col++) {
            if (isSafe(row, col)) {
                queens[row] = col; // 在第row行放置皇后
                placeQueen(row + 1); // 放置下一行的皇后
            }
        }
    }

    /**
     * 安全检查
     * @param row
     * @param col
     * @return
     */
    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || // 同一列
                    Math.abs(i - row) == Math.abs(queens[i] - col)) { // 同一对角线
                return false;
            }
        }
        return true;
    }

    /**
     * 打印出符合的棋盘
     */
    private void printSolution() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (queens[i] == j) {
                    System.out.print("♛ ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FourQueens fourQueens = new FourQueens();
        fourQueens.solve();
    }
}
