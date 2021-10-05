package study.programmers.heap

/*
 * 2020-10-28
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */

import java.util.PriorityQueue

class DiskController {
    fun solution(jobs: Array<IntArray>): Int {
        // 입력 배열 정렬
        val jobQueue = PriorityQueue<IntArray> { o1, o2 ->
            when {
                o1[0] > o2[0] -> 1
                o1[0] < o2[0] -> -1
                else -> o1[1].compareTo(o2[1])
            }
        }

        jobs.forEach {
            jobQueue.add(it)
        }

        val queue = PriorityQueue<IntArray> { o1, o2 ->
            o1[1].compareTo(o2[1])
        }

        // 총 사용 시간
        var answer = 0

        val job = jobQueue.poll()
        queue.add(job)

        // 현재 작업 진행 시간
        var jobTime = job[0]

        while (queue.isNotEmpty()) {
            val nowJob = queue.poll()
            jobTime += nowJob[1]

            answer += if (jobTime < nowJob[0]) {
                nowJob[1]
            } else {
                jobTime - nowJob[0]
            }

            // 현재 작업 시간 전에 들어온 작업들을 우선 순위 큐에 넣음
            while (jobQueue.peek() != null && jobQueue.peek()[0] < jobTime) {
                val nextJob = jobQueue.poll()
                queue.add(nextJob)
            }

            // 작업 큐가 비면 추가적으로 작업을 넣음
            if (queue.isEmpty() && jobQueue.peek() != null && jobQueue.peek()[0] >= jobTime) {
                val nextJob = jobQueue.poll()
                queue.add(nextJob)
                jobTime = nextJob[0]
            }
        }
        return answer / jobs.count()
    }
}
