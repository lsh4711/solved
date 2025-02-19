//  개수 세기

fun main(args: Array<String>) {
    val N = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val v = readln().toInt()
    val count = numbers.count { it == v }

    println(count)
}
