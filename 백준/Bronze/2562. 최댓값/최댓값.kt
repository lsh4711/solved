//  최댓값

fun main(args: Array<String>) {
    val numbers = Array(9) { readln().toInt() }
    val max = numbers.max()
    val index = numbers.indexOf(max) + 1

    println(
        """
        $max
        $index
    """
            .trimIndent()
    )
}
