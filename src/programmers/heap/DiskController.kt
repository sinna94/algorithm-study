package programmers.heap

/*
 * 2020-09-09
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */

import java.util.*

class DiskController {
    fun solution(jobs: Array<IntArray>): Int {
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

//        val queue = PriorityQueue<IntArray> { o1, o2 -> when{
//            o1[0] > o2[0] -> -1
//            o1[0] < o2[0] -> 1
//            else ->
//            o1[1].compareTo(o2[1])
//        } }

        val queue = PriorityQueue<IntArray> { o1, o2 ->
            o1[1].compareTo(o2[1])
        }

        var answer = 0
        var jobTime = 0

        val job = jobQueue.poll()
        queue.add(job)

//        while (jobQueue.peek() != null && jobQueue.peek()[0] == job[0]) {
//            val nextJob = jobQueue.poll()
//            queue.add(nextJob)
//        }

        while (queue.isNotEmpty()) {
            val nowJob = queue.poll()
            println("${nowJob[0]} : ${nowJob[1]}")
            jobTime += nowJob[1]
            answer += if (answer < nowJob[0]) {
                nowJob[1]
            } else {
                jobTime - nowJob[0]
            }

            while (jobQueue.peek() != null && jobQueue.peek()[0] < jobTime) {
                val nextJob = jobQueue.poll()
                queue.add(nextJob)
            }

            if(queue.isEmpty() && jobQueue.peek() != null && jobQueue.peek()[0] >= jobTime){
                val nextJob = jobQueue.poll()
                queue.add(nextJob)
                jobTime = nextJob[0]
            }
//            if (queue.isEmpty()) {
//                val nextJob = jobQueue.peek()
//                if (nextJob != null) {
//                    jobTime = nextJob[0]
//                    while (jobQueue.peek() != null && jobQueue.peek()[0] == nextJob[0]) {
//                        val nextJob = jobQueue.poll()
//                        queue.add(nextJob)
//                    }
//                }
//            }
        }
        return answer / jobs.count()
    }
}