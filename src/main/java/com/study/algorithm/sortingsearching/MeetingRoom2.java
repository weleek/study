package com.study.algorithm.sortingsearching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {
    /**
     * 미팅 시갂 배열이 주어집니다. intervals[i] = [start, end]
     * intervals 배열을 이용하여 사람들이 회의에 참석할려면 몇 개의 회의실이 필요한지 리턴하세요
     *
     * 제한사항
     * intervals 의 길이는 0 이상 10_000 이하
     * 회의 시간은 시작과 종료로 길이 2로 고정
     * 시작시간은 0 이상 종료 미만
     * 종료시간은 시작 초과 1_000_000 이하
     *
     * 입출력 예
     * intervals                        return
     * [[5,10], [16,20], [0,30]]        2
     * [[6,10],[1,3]]                   1
     */
    public int solution(int[][] intervals) {
        // 오름차순 정렬
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (int[] arr: intervals) {
            if (pq.isEmpty()) {
                pq.offer(arr);

            } else {
                // 이전 회의의 종료시간 >= 다음회의 시작시간 같다면 pq에 들어간 값을 교체
                if (pq.peek()[1] <= arr[0]) {
                    pq.poll();
                }
                pq.offer(arr);
            }
        }

        return pq.size();
    }
}
