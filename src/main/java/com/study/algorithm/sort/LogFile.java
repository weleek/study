package com.study.algorithm.sort;

import java.util.Arrays;

public class LogFile {
    /**
     * 배열로 logs 주어집니다.
     * 각 로그는 공백으로 구분 된 단어 문자열이며 첫 번째 단어는 식별자 입니다.
     *
     * There are two types of logs:
     * Letter-logs: All words (except the identifier) consist of lowercase English letters.
     * Digit-logs: All words (except the identifier) consist of digits.
     *
     * Reorder these logs so that:
     * The letter-logs come before all digit-logs.
     * The letter-logs are sorted lexicographically by their contents.
     * If their contents are the same, then sort them lexicographically by their identifiers.
     * The digit-logs maintain their relative ordering.
     * Return the final order of the logs.
     *
     *제한사항
     * 1 <= logs.length <= 100, 3 <= logs[i].length <= 100
     * All the tokens of logs[i] are separated by a single space.
     * logs[i] is guaranteed to have an identifier and at least one word after the identifier.
     *
     * 입출력 예
     * Input: logs = ["dig1 8 2 3 1",
     *                "let1 abc cat",
     *                "dig1 2 5",
     *                "let2 good dog book",
     *                "let3 abc zoo" ]
     * Output: ["let1 abc cat",
     *          "let3 abc zoo",
     *          "let2 good dog book ",
     *          "dig1 8 2 3 1",
     *          "dig1 2 5"]
     * Explanation:
     * The letter-log contents are all different, so their ordering is "abc cat", "abc zoo", "
     * good dog book".
     * The digit-logs have a relative order of "dig1 8 2 3 1", "dig1 2 5".
     */

    public String[] solution(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s1.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2) {
                // 1. 모두 문자
                // 본문 비교
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) {
                    // 본문의 내용이 같다면 식별자를 비교
                    return split1[0].compareTo(split2[0]);
                } else {
                    return comp;
                }

            } else if (isDigit1 && isDigit2) {
                // 2. 모두 숫자.
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // 3. 첫번째는 숫자, 두번째는 문자.
                return 1;
            } else {
                // 4. 첫번째는 문자, 두번째는 숫자.
                return -1;
            }
        });
        
        return logs;
    }
}
