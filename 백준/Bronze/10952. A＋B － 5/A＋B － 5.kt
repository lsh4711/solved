//  A+B - 5

fun main(args: Array<String>) {
    while (true) {
        val input = readln()
        val (A, B) = input.split(" ").map { it.toInt() }

        if (A == 0 && B == 0) {
            return
        }

        handleCase(A, B)
    }
}

fun handleCase(A: Int, B: Int) {
    println(A + B)
}
