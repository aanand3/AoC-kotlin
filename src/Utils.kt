import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

/**
 * Converts List of String to List of Int
 */
fun listToInt(input: List<String>) = input.map { it.toInt() }

/**
 * Reads comma separated strings from the given input txt file
 */
fun readCommaSeparated(name: String): List<String> = File("src", "$name.txt").readText().split(",")