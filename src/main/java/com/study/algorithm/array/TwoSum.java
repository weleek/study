package com.study.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 두개 함
     * 정수의 배열 nums와 정수 target이 주어집니다.
     * 배열 nums에서 두 숫자의 값을 더하여 target값과 동일할 경우 두 숫자의 인덱스를 리턴합니다
     * 각 입력에 정확히 하나의 솔루션 이 있다고 가정하며, 동일한 요소를 두 번 사용할 수 없습니다 .
     * Note) 시간복잡도 O(n)으로 수행하세요
     *
     * 제한사항
     * 2 <= nums.length <= 10_4
     * -10_9 <= nums[i] <= 10_9
     * -10_9 <= target <= 10_9
     *
     * 입출력 예
     * Input: nums = [2, 8, 11, 14], target= 16
     * Output: [1,4]
     * Because nums[0]+nums[3] = 2 + 14 = 16
     * return [1, 4].
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [2,3]
     *
     */

    public int[] solution(int[] nums, int target) {
        /**
         * 시간복잡도를 고려하지 않은 방식
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j<length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        */

        // 시간 복잡도를 고려한 방식
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 들어온 숫자를 키 값으로 사용하여 map에서 존재한다면 해당 인덱스 번호와 현재 인덱스 번호를 저장한다.
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                result[0] = val + 1;
                result[1] = i + 1;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}
