package com.study.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    /**
     * 보석(jewels)과 돌(stones) 이 주어집니다.
     * 보석을 이용해서 돌에 얼마나 맋은 보석이 포함되어 있는지 알고 싶습니다.
     *
     * 제한사항
     * 보석 문자열의 길이는 1 이상 입니다.
     * 돌 문자열의 길이는 50보다 작거나 같습니다.
     * 문자는 대소 문자를 구분하므로 "a"와 "A＂은 다른 유형의 스톤으로 간주됩니다 .
     *
     * 입출력 예
     * jewels   stones          return
     * "aA"     "aAAbbbb"       3
     * "z"      "ZZ"            0
     *
     */
    public int solution(String jewels, String stones) {
        int result = 0;
        Set<Character> jewelsSet = new HashSet<>();

        char[] jewelsChars = jewels.toCharArray();
        for (int i = 0; i < jewelsChars.length; i++) {
            jewelsSet.add(jewelsChars[i]);
        }

        char[] stonesChars = stones.toCharArray();
        for (int i = 0; i < stonesChars.length; i++) {
            if (jewelsSet.contains(stonesChars[i])) {
                result++;
            }
        }
        return result;
    }
}
