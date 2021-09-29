package com.study.algorithm.sort;

public class MoveZero {
    /**
     * 제로 이동
     * 정수 배열(nums)이 주어지면 0이 아닌 값은 상대적 순서를 유지하고 0은 끝으로 이동하게 만드세요.
     *
     * 제한사항
     * 정수배열의 길이는 1 이상 10의 4승 이하입니다.
     * 정수의 크기는 -2의 31승 이상 2의 31승 -1 이하 입니다.
     *
     * 입출력 예
     * ints         return
     * 0,3,2,0,8,5  3,2,8,5,0,0
     */

    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] != 0) {
                numbers[index] = numbers[i];
                if (i != index) {
                    numbers[i] = 0;
                }
                index++;
            }
        }

        /**
         * 앞에서 부터 채울 경우
        int n = numbers.length;
        int index = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (numbers[i] != 0) {
                numbers[index] = numbers[i];
                if (i != index) {
                    numbers[i] = 0;
                }
                index--;
            }
        }

        */
        return numbers;
    }

    public static void main(String[] args) {
        int[] n = {0, 3, 2, 0, 8, 5};
        MoveZero moveZero = new MoveZero();
        moveZero.solution(n);
    }
}
