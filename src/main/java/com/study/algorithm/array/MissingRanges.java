package com.study.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    /**
     * 누락된 범위
     * 모든 요소를 포함하는 범위[lower, upper]와 정렬된 고유한 정수 배열 nums와 주어집니다.
     * 만약에 x라는 number가 범위[lower, upper]존재하고 nums배열에 없다면
     * 누락된 값으로 갂주합니다.
     * 누락된 모든 숫자를 정확히 포함하는 가장 작은 정렬된 범위를 리턴합니다.
     * 표현형식은 아래와 같습니다.
     *
     * [a,b]목록의 각 범위 는 다음과 같이 출력되어야합니다.
     * "a->b" if a != b
     * "a" if a == b
     *
     * 제한사항
     * -1000_000_000 <= lower <= upper <= 1000_000_000
     * 0 <= nums.length <= 100
     * lower <= nums[i] <= upper
     * All the values of nums are unique.
     *
     * 입출력 예
     * Input: nums = [2,3,5,50,75], lower = 0, upper = 99
     * Output: [0->1, 4, 6->49, 51->74, 76->99]
     * Explanation: 전체 범위가 0-99 입니다.
     * nums[0]==2입니다. 0,1 빠졌으므로 0->1로표시
     */

    public List<String> solution(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // nums의 첫번째 순번 값과 lower를 비교하여 첫번째 배열의 값을 구하기
        if (lower < nums[0]) {
            result.add(makeRange(lower, nums[0] - 1));
        }

        // 중간 범위에 있는 nums 배열의 값을 구하기
        for (int i = 0; i < nums.length - 1; i++) {
            // 현재 인덱스의 숫자 값의 다음 숫자 값과 다음 인덱스 순번의 값을 비교
            if (nums[i] != nums[i +1 ] && nums[i] + 1 < nums[i + 1]) {
                // 현재 인덱스의 값의 다음 숫자 값과 다음 인덱스의 값 - 1 값을 추출하여 low와 high 값을 뽑기
                result.add(makeRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // nums의 마지막 순번의 값과 upper를 비교하여 마지막 배열의 값을 구하기
        if (nums[nums.length - 1] < upper) {
            result.add(makeRange(nums[nums.length - 1] + 1, upper));
        }

        return result;
    }

    private static String makeRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}
