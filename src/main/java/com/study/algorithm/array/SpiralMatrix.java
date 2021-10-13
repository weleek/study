package com.study.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * 나선형 매트릭스
     * Given a matrix of m x n elements (m rows, n columns),
     * return all elements of the matrix in spiral order.
     *
     * 제한사항
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][ j] <= 100
     *
     * 입출력 에
     * Input: int[][] matrix = {{ 1, 2, 3, 4}, { 5, 6, 7, 8}, { 9 ,10, 11, 12}};
     * Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
     */

    public List<Integer> solution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        // 로우와 컬럼을 구분하여 진행 방향으로의 로직을 각각 구하여 준다. 오른쪽, 아래쪽, 왼쪽, 위쪽

        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 오른쪽 방향 구하기
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // 아래 방향 구하기
            for(int i= rowStart; i <= rowEnd; i++ ) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // 왼쪽 방향 구하기
            if(rowStart <= rowEnd){
                for(int i= colEnd; i >= colStart; i-- ) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // 위쪽 방향 구하기
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }

        return result;
    }
}
