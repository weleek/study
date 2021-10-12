package com.study.algorithm.array;

public class TrappingRainWater {
    /**
     * elevation map(양의 정수)은 아래그림에서 검은 네모모양이며 너비가 1이다
     * 비가 내린 후 가둘 수있는 물의 양을 계산합니다.
     *
     * 제한사항
     * n == height.length
     * 0 <= n <= 3 * 10_000
     * 0 <= height[i] <= 100_000
     *
     * 입출력 예
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: elevation map (검은부분) 표시 부분 [0,1,0,2,1,0,1,3,2,1,2,1]
     *  빗물부분 (파띾색 부분)은 6개 unit임
     */
    public int solution(int[] height) {
        int result = 0;
        if (height == null || height.length <= 2) {
            return result;
        }

        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int max = height[0];
        left[0] = height[0];

        // 왼쪽 벽 구하기
        for (int i = 1; i < len; i++) {
           if (height[i] < max) {
               left[i] = max;
           }
           else {
               left[i] = height[i];
               max = height[i];
           }
        }

        // 오른쪽 벽 구하기
        max = height[len - 1];
        right[len - 1] = height[len - 1];

        for (int i = len-2; i >= 0; i--) {
            if (height[i] < max) {
                right[i] = max;
            }
            else {
                right[i] = height[i];
                max = height[i];
            }
        }

        // 왼쪽 오른쪽 벽중 작은 값에서 높이 만큼 빼준다.
        for (int i = 0; i < len; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }


}
