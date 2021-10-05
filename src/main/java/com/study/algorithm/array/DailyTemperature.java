package com.study.algorithm.array;

import java.util.Stack;

public class DailyTemperature {
    /**
     * 일일 온도를 나타내는 int 배열(temperatures)이 주어집니다.
     * 더 따뜻한 날씨의 날을 얻기 위해 해당날짜 이후에 기다려야하는 날짜의 수를 배열로 리턴하세요 .
     * 더 따뜻한 날이 오지 않는다면 0을 리턴하세요.
     *
     * 제한사항
     * 1 <= temperatures.length <= 100_000
     * 30 <= temperatures[i] <= 100
     *
     * 입출력 예
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * Output: [1,1,4,2,1,1,0,0]
     *
     * Input: temperatures = [30,40,50,60]
     * Output: [1,1,1,0]
     *
     */

    public int[] solution(int[] nums) {
        if (nums.length <= 0 || nums.length > 100_000) {
            throw new RuntimeException();
        }

        int limit = nums.length;
        int[] result = new int[limit];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < limit; i++) {
            // 스택의 마지막 인덱스의 값과 nums의 값을 비교 하여 온도가 큰지 비교
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();        // 스택의 마지막 저장된 인덱스를 꺼낸다
                result[index] = i - index;      // 현재 순번에서 스택의 마지막 인덱스를 빼주어서 결과값의 인덱스 번지에 값을 넣어준다.
            }
            stack.push(i);          // 스택에 인덱스를 저장
        }
        return result;
    }
}
