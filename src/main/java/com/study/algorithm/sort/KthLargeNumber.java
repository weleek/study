package com.study.algorithm.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargeNumber {
    /**
     * K 번째 큰 원소
     * 정수 배열 nums와 정수 k가 주어지면 배열에서 k번째로 큰 요소를 반환합니다
     * Note) k번째로 큰 요소는 정렬후 값에대한 가장 큰 요소가 아닌 유일한(distinctive) 순서 요소입니다.
     *
     * 제한사항
     * k는 1 이상 10의 4승 이하 이며 정수 배열의 길이를 넘을 수 없습니다.
     * 정수는 -10의 4승 이상 10의 4승 이하 입니다.
     *
     * 입출력 예
     * array                    k
     * [2, 3, 1, 5, 6, 4]       2
     */
    public int solution(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }

    public int solutionByPriorityQueue(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i: nums) {
            priorityQueue.offer(i);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
