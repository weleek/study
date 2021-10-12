package com.study.algorithm.array;

import java.util.*;

public class GroupAnagrams {
    /**
     * String 배열이 주어집니다. 주어진 String은 배열안에서 다른 String과 아나그램 관계입니다.
     * String 순서 상관없이 같은 아나그램을 리턴하세요
     * 아나그램이란? 문자의 단어를 재배열하여 새로운 문자를 형성하는 것입니다.
     * 즉, 같은 알파벳으로 구성된 단어끼리 묶어 출력하는 문제입니다
     *
     * 제한사항
     * 1 <= strs.length <= 10_000
     * 0 <= strs[i].length <= 100
     * strs[i]은 영어소문자로만 구성되었습니다.
     *
     * 입출력 예
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * Input: strs = [""]
     * Output: [[""]]
     */
    public List<List<String>> solution(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0)  {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);

            String key = String.valueOf(charArr);

            // 일반 if else
//            if (map.containsKey(key)) {
//                map.get(key).add(str);
//            }
//            else {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(key, list);
//            }

            // 함수 이용
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

//        return new ArrayList<>(map.values());
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public List<List<String>> solution_ascii(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        if (strs == null || strs.length == 0)  {
            return result;
        }

        for (String str: strs) {
            int[] count = new int[26]; // a-z
            for (int k = 0; k < strs.length; k++) {
                count[str.charAt(k) - 'a']++;   // 아스키값으로 가진 고유값으로 이루어진 배열을 키 값으로 사용
            }
            String key = Arrays.toString(count);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
