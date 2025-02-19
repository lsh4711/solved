//  X보다 작은 수

fun main(args: Array<String>) {
    val (N, X) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }
    val result = numbers.filter { it < X }

    println(result.joinToString(" "))
}
