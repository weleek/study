package com.study.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {
    /**
     * 가장 큰 수
     * 문제 설명
     * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
     *
     * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
     *
     * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한 사항
     * numbers의 길이는 1 이상 100,000 이하입니다.
     * numbers의 원소는 0 이상 1,000 이하입니다.
     * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
     * 입출력 예
     * numbers	return
     * [6, 10, 2]	"6210"
     * [3, 30, 34, 5, 9]	"9534330"
     */

    public String solution(int[] numbers) {
        if (numbers.length < 1 || numbers.length > 1_000_000) {
            throw new RuntimeException();
        }
        List<String> list = new ArrayList<>(numbers.length);
        for (int number : numbers) {
            if (number < 0 || number > 1_000) {
                throw new RuntimeException();
            }
            list.add(String.valueOf(number));
        }

        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (list.get(0).equals("0")) {
            return "0";
        }

        return String.join("", list);
        /**
         * 유저 베스트 : stream 활용
         * return Arrays.stream(numbers)
         *         .mapToObj(String::valueOf)
         *         .sorted((s1, s2) -> -s1.concat(s2).compareTo(s2.concat(s1)))
         *         .reduce("", (s1, s2) -> s1.equals("0") && s2.equals("0") ? "0" : s1.concat(s2));
         */
    }

}
