package day03

import readInput
import java.time.LocalDate

fun main() {
    fun part1(input: List<String>): Int {
        var gamma = "";
        var epsilon = "";

        for (i in 0 until input[0].length) {
            var ones = input.filter { it[i] == '1' }

            gamma += if (ones.size > (input.size / 2)) '1' else '0'
            epsilon += if (gamma[i] == '1') '0' else '1'
        }

        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);
    }

    fun part2(input: List<String>): Int {
        var oxygen = input
        var carbon = input

        for (i in 0 until input[0].length) {
            if (oxygen.size == 1) break;
            val (oxygenOnes, oxygenZeroes) = oxygen.partition { it[i] == '1' }
            oxygen = if (oxygenOnes.size >= oxygenZeroes.size) oxygenOnes else oxygenZeroes
        }

        for (i in 0 until input[0].length) {
            if (carbon.size == 1) break;
            val (carbonOnes, carbonZeroes) = carbon.partition { it[i] == '1' }
            carbon = if (carbonZeroes.size <= carbonOnes.size) carbonZeroes else carbonOnes
        }

        return Integer.parseInt(oxygen[0], 2) * Integer.parseInt(carbon[0], 2);
    }

    val date = LocalDate.now().dayOfMonth
    val testInput = readInput("day0${date}/day_0${date}_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("day0${date}/day_0${date}")
    println(part1(input))
    println(part2(input))
}
