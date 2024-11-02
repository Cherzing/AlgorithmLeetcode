package cn.cherzing.AlgorithmDesign;

import java.util.Scanner;

/**
 * @author Cherzing
 * @detail cherzing.cn
 * @date 2024/10/31 0031 17:13
 * @description Divide And Conquer
 */
public class DivideAndConquer {
    public static void main(String[] args) {
        int BOARD_SIZE = 4; // 设置为4

        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        Solution solution = new Solution();
        solution.chessBoard(board, 0, 0,  0, 1, BOARD_SIZE,1);

        // 打印棋盘
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    /**
     *
     * @param board 棋盘赋值
     * @param row 棋盘左上角行号
     * @param col 棋盘左上角行号
     * @param specialRow 特殊棋盘的行号
     * @param specialCol 特殊棋盘的列号
     * @param size 棋盘的规格为2^k*2^k
     * @param tile 骨牌变化
     */
    public void chessBoard(int[][] board, int row, int col, int specialRow, int specialCol, int size, int tile) {

        // 递归出口
        if (size == 1)
            return;
        int s = size / 2; //分割棋盘
        int t = tile++;
        // 在棋盘的四个子区域中放置骨牌
        // 左上角子棋盘
        // 判断特殊方格在不在左上棋盘
        if (specialRow < row + s && specialCol < col + s) {
            chessBoard(board, row, col, specialRow, specialCol, s,tile++); //特殊方格在左上棋盘的递归处理方法
        } else {
            board[row + s - 1][col + s - 1] = t;             // 用t号的L型骨牌覆盖右下角
            chessBoard(board,row, col, row + s - 1, col + s - 1, s,tile++); // 递归覆盖其余方格
        }
        // 判断特殊方格在不在右上棋盘
        if (specialRow < row + s && specialCol >= col + s) {
            chessBoard(board,row, col + s, specialRow, specialCol, s,tile++);
        } else {
            board[row + s - 1][col + s] = t;
            chessBoard(board,row, col + s, row + s - 1, col + s, s,tile++);
        }
        // 判断特殊方格在不在左下棋盘
        if (specialRow >= row + s && specialCol < col + s) {
            chessBoard(board,row + s, col, specialRow, specialCol, s,tile++);
        } else {
            board[row + s][col + s - 1] = t;
            chessBoard(board,row + s, col, row + s, col + s - 1, s,tile++);
        }

        // 判断特殊方格在不在右下棋盘
        if (specialRow >= row + s && specialCol >= col + s) {
            chessBoard(board,row + s, col + s, specialRow, specialCol, s,tile++);
        } else {
            board[row + s][col + s] = t;
            chessBoard(board,row + s, col + s, row + s, col + s, s,tile++);
        }
    }
}
