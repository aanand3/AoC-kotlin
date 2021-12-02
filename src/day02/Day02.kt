package day02

import readInput
import java.time.LocalDate

fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition = 0;
        var depth = 0;

        input.forEach {
            val (direction, amount) = it.split(" ")
            when (direction) {
                "forward" -> horizontalPosition += amount.toInt()
                "up" -> depth -= amount.toInt()
                "down" -> depth += amount.toInt()
            }
        }

        return horizontalPosition * depth
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition = 0;
        var depth = 0;
        var aim = 0;

        input.forEach {
            val (direction, amount) = it.split(" ")
            when (direction) {
                "forward" -> {
                    horizontalPosition += amount.toInt()
                    depth += (amount.toInt() * aim)
                }
                "up" -> aim -= amount.toInt()
                "down" -> aim += amount.toInt()
            }
        }

        return horizontalPosition * depth
    }

    // test if implementation meets criteria from the description, like:
    val date = LocalDate.now().dayOfMonth
    val testInput = readInput("day0${date}/day_0${date}_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("day0${date}/day_0${date}")
    println(part1(input))
    println(part2(input))
}
