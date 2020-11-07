/*
 * 2020-08-08
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */

class TruckPassingTheBridge {
  fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var passingList = ArrayList<Pair<Int, Int>>()
    var time = 0
    val truckList = truck_weights.toMutableList()
    var truck = truckList.removeAt(0)

    do {
      time++
      passingList = passingList.filter { truckPair ->
        truckPair.second < bridge_length - 1
      }.map { truckPair ->
        Pair(truckPair.first, truckPair.second + 1)
      } as ArrayList<Pair<Int, Int>>

      if (truck + passingList.map { it.first }.sum() <= weight) {
        val truckListCount = truckList.count()
        if (truck > 0) {
          passingList.add(Pair(truck, 0))
        }
        when {
          truckListCount > 0 -> {
            truck = truckList.removeAt(0)
          }
          truckListCount == 0 -> {
            truck = 0
          }
        }
      }
    } while (passingList.isNotEmpty())
    return time
  }
}

fun main() {
  val result = TruckPassingTheBridge().solution(
    100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
//        100, 100, intArrayOf(10)
//        2, 10, intArrayOf(7, 4, 5, 6)
  )
  println(result)
}
