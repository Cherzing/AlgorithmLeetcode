package cn.cherzing.AlgorithmDesign;

/**
 * @author Cherzing
 * @date 2024/10/31 0031 19:43
 * @description ChessboardCoverage
 */
public class ChessboardCoverage {
    public static void main(String[] args) {
        int k = 3; // 棋盘大小为2^k*2^k
        int specialRow = 2; // 特殊方格的行索引
        int specialCol = 3; // 特殊方格的列索引
        int[][] board = new int[1 << k][1 << k]; // 创建棋盘

        cover(board, 0, 0, specialRow, specialCol, 1 << k);

        // 打印覆盖后的棋盘
        for (int i = 0; i < (1 << k); i++) {
            for (int j = 0; j < (1 << k); j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void cover(int[][] board, int row, int col, int specialRow, int specialCol, int size) {
        if (size == 1) {
            return;
        }

        int quadrantSize = size / 2;
        int tile = 1; // 用于标记L型骨牌

        // 检查特殊方格是否在左上角象限
        if (specialRow < row + quadrantSize && specialCol < col + quadrantSize) {
            cover(board, row, col, specialRow, specialCol, quadrantSize);
        } else {
            // 如果特殊方格不在左上角象限，则将左上角象限的右下角方格标记为特殊方格
            board[row + quadrantSize - 1][col + quadrantSize - 1] = tile;
            cover(board, row, col, row + quadrantSize - 1, col + quadrantSize - 1, quadrantSize);
        }

        // 检查特殊方格是否在右上角象限
        if (specialRow < row + quadrantSize && specialCol >= col + quadrantSize) {
            cover(board, row, col + quadrantSize, specialRow, specialCol, quadrantSize);
        } else {
            // 如果特殊方格不在右上角象限，则将右上角象限的左下角方格标记为特殊方格
            board[row + quadrantSize - 1][col + quadrantSize] = tile;
            cover(board, row, col + quadrantSize, row + quadrantSize - 1, col + quadrantSize, quadrantSize);
        }

        // 检查特殊方格是否在左下角象限
        if (specialRow >= row + quadrantSize && specialCol < col + quadrantSize) {
            cover(board, row + quadrantSize, col, specialRow, specialCol, quadrantSize);
        } else {
            // 如果特殊方格不在左下角象限，则将左下角象限的右上角方格标记为特殊方格
            board[row + quadrantSize][col + quadrantSize - 1] = tile;
            cover(board, row + quadrantSize, col, row + quadrantSize, col + quadrantSize - 1, quadrantSize);
        }

        // 检查特殊方格是否在右下角象限
        if (specialRow >= row + quadrantSize && specialCol >= col + quadrantSize) {
            cover(board, row + quadrantSize, col + quadrantSize, specialRow, specialCol, quadrantSize);
        } else {
            // 如果特殊方格不在右下角象限，则将右下角象限的左上角方格标记为特殊方格
            board[row + quadrantSize][col + quadrantSize] = tile;
            cover(board, row + quadrantSize, col + quadrantSize, row + quadrantSize, col + quadrantSize, quadrantSize);
        }

        // 用新的L型骨牌覆盖中间部分
        for (int i = row + quadrantSize - 1; i <= row + quadrantSize; i++) {
            for (int j = col + quadrantSize - 1; j <= col + quadrantSize; j++) {
                if (board[i][j]!= tile) {
                    board[i][j] = tile + 1;
                }
            }
        }
    }
}