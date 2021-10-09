package com.study.algorithm.array;

public class MaximumSubArray {
    /**
     * 정수 배열 nums가 주어지면 합계가 가장 큰 연속 하위 배열 (최소한 하나의 숫자 포함)을 찾아서
     * 합계를 리턴합니다.
     * Note) 시간복잡도 O(n)으로 구하세요
     *
     * 제한사항
     * 1 <= nums.length <= 3 * 10_000
     * -100_000 <= nums[i] <= 100_000
     *
     * 입출력 예
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1]
     *
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     */

    public int solution(int[] nums) {
        int curMax = nums[0];
        int allMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 현재 인덱스의 번호와 이전 인덱스부터의 가장 큰 합을 비교한 수 중 큰 숫자만 담는다.
            curMax = Math.max(nums[i], nums[i] + curMax);

            // 전체 합과 서브 어레이 합중 더 큰 값으로 담는다.
            allMax = Math.max(allMax, curMax);
        }
        return allMax;
    }
}
