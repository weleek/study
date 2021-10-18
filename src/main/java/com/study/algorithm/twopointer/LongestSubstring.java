package com.study.algorithm.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    /**
     * 단어중복없는 가장긴 문자열
     * String s가 주어집니다. 중복이 없는 가장 긴 substring 문자열을 리턴하세요
     *
     * 제한사항
     * 0 <= s.length <= 5 * 10_000
     * s consists of English letters
     *
     * 입출력 예
     * Input: s = "abcabcd"
     * Output: 4
     * Explanation: "abcd"
     *
     * Input: s = "pwwkea"
     * Output: 4
     * Explanation: "wkea"
     *
     * Input: s = “aaaaa"
     * Output: 1
     * Explanation: “a"
     *
     * Input: s = "“
     * Output: 0
     */

    public int solution(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, counter = 0, max = 0;

        // 오른쪽 방향의 진행 값이 문자열의 길이보다 작은 경우
        while(right < s.length()) {
            char c = s.charAt(right);

            // 해당 문자의 값을 맵에 있는지 체크하여 기본값을 저장
            map.put(c, map.getOrDefault(c, 0) + 1);

            // 중복이 발견 된 경우 카운터 증가
            if (map.get(c) > 1) {
                counter++;
            }

            // 진행방향 증가
            right++;

            // 중복값에 대한 문자열 초기화
            while(counter > 0) {
                char c2 = s.charAt(left);

                if (map.get(c2) > 1) {
                    counter--;
                }
                map.put(c2, map.get(c2) - 1);
                left++;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }
}
