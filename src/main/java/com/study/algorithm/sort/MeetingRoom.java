package com.study.algorithm.sort;

import java.util.Arrays;

public class MeetingRoom {
    /**
     * 미팅 시갂 배열이 주어집니다. intervals[i] = [start, end]
     * intervals 배열을 이용하여 사람들이 모든 회의에 참석할 수 있는지 boolean으로 리턴하세요
     *
     * 제한사항
     * intervals의 길이는 0 이상 10_000 이하
     * 미팅 시간의 길이는 2고정 (시작, 종료)
     * 시작시간은 0이상 종료 미만
     * 종료시간은 시작 초과 1_000_000 이하
     *
     * 입출력 예
     * intervals                        output
     * [[5,10], [16,20], [0,30]]        false
     * [[6,10], [1,3]]                  true
     * */

    public boolean solution(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        // 오름차순 정렬
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // 첫번째 회의의 종료시간과 이후 회의의 시작시간을 비교한다
        int end = intervals[0][1];
        int length = intervals.length;;
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] < end) {
                return false;
            }
            end = intervals[i][1];
        }

        return true;
    }

}
