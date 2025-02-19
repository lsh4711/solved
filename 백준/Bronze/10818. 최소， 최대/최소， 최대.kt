//  최소, 최대

fun main(args: Array<String>) {
    val N = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val min = numbers.min()
    val max = numbers.max()

    println("$min $max")
}
