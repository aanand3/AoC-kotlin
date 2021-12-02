package day01

import listToInt
import readInput

fun main() {
    fun part1(input: List<Int>): Int {
        var increasedCount = 0
        for (i in 1 until input.size){
            if (input[i] > input[i-1]) increasedCount++
        }
        return increasedCount
    }

    fun part2(input: List<Int>): Int {
        val sums = input.windowed(3) {it.sum()}
        return part1(sums)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = listToInt(readInput("day01/day_01_test"))
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = listToInt(readInput("day01/day_01"))
    println(part1(input))
    println(part2(input))
}
