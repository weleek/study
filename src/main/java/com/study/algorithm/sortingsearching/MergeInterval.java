package com.study.algorithm.sortingsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    /**
     * intervals 배열이 주어지면 겹치는 구갂을 병합하여 배열을 반환 합니다
     *
     * 제한사항
     * 1 <= intervals.length <= 10_000
     * intervals[i].length == 2
     * 0 <= start <= end <= 10_000
     *
     * 입출력 예
     * intervals                                return
     * [[1,4],[2,6],[8,10],[15,18]]             [[1,6],[8,10],[15,18]]   ([1,4] [2,6] 오버랩되므로, [1,6]으로 병합시킵니다.)
     * [[1,5],[5,6]]                            [[1,6]]
     *
     */

    public int[][] solution(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return result.toArray(new int[0][]);
        }

        // 오름차순 정렬
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 이전 종료시간이 현재 시작시간보다 큰 경우
            if (end >= intervals[i][0]) {
                // 회의 종료 시간이 큰 값으로 초기화
                end = Math.max(end, intervals[i][1]);

            } else {
                result.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
           }

        }

        result.add(new int[] {start, end} );

        return result.toArray(new int[result.size()][]);
    }
}
