package com.study.algorithm.integer;

public class PlusOne {
    /**
     * 음이 아닌 정수를 나타내는 비어 있지 않은 십진수 배열이 주어지면 정수 1을 증가시킵니다.
     * 배열의 마지막에 숫자에 +1을 합니다.
     * 숫자 0 자체를 제외하고 정수에 앞에 0이 포함되지 않습니다.
     *
     * 제한사항
     * 십진수 배열의 길이는 1 이상 100 이하입니다.
     * 십진수 배열의 값의 범위는 0이상 9이하입니다.
     *
     * 입출력 예
     * digit        return
     * 1,2,3        1,2,4
     * 9,9,9        1,0,0,0
     */

    public int[] solution(int[] unsignedInts) {
        int n = unsignedInts.length;

        for (int i = n -1; i>=0; i--) {
            unsignedInts[i]++;
            if (unsignedInts[i] < 10) {
                return unsignedInts;
            }
            unsignedInts[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
