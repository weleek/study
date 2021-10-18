package com.study.algorithm.sortingsearching;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosetPointsToOrigin {
    /**
     * 원점에 가장 가까운 지점
     * XY 평면의 한 점 과 정수를 나타내는 배열이 주어지면 원점에 가장 가까운 점을 반환합니다.
     * XY 평면 에서 두 점 사이의 거리 구하는 공식을 이용하세요.√(x1
     * 루트/(x2 - x1)2 * (y2 - y1)2
     * 원점에서 제일 가까운 좌표를 K개의 갯수만큼 리턴하세요
     *
     * 제한사항
     * 1 <= k <= points.length <= 10의 4승
     * -10의 4승 < xi, yi < 10의 4승
     *
     * 입출력 예
     * points                   k            return
     * [3,3],[5,-1],[-2,4]]     2            [[3,3],[-2,4]]
     */
    public int[][] solution(int[][] points, int k) {
        // 우선순위큐에 데이러를 담을때 비교식을 주어진 공식으로 지정 (Max Heap)
        Queue<int[]> pq = new PriorityQueue<>((b, a) ->
                (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

        int[][] result = new int[k][2];

        for (int[] p: points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int index = 0;
        while (index < k) {
            result[index] = pq.poll();
            index++;
        }

        return result;
    }
}
