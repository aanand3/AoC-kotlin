package day07

import listToInt
import readCommaSeparated
import kotlin.math.abs

fun main() {

    fun calculateCost(input: List<Int>, cost: (Int, Int) -> Int) =
        IntRange(input.minOrNull()!!, input.maxOrNull()!!).map {
            input.distinct()
                .fold(0) { sum, element ->
                    sum + cost(element, it) * input.count { num -> num == element }
                }
        }.minOrNull() ?: 0

    fun distanceCost(element: Int, location: Int): Int {
        return abs(element - location)
    }

    fun genSum(element: Int, location: Int): Int {
        val distance = abs(element - location)
        return (distance * (distance + 1)) / 2
    }

    val testInput = listToInt(readCommaSeparated("day07/day_07_test"))
    check(calculateCost(testInput, ::distanceCost) == 37)
    check(calculateCost(testInput, ::genSum) == 168)

    val input = listToInt(readCommaSeparated("day07/day_07"))
    println("part 1: " + calculateCost(input, ::distanceCost))
    println("part 2: " + calculateCost(input, ::genSum))
}

