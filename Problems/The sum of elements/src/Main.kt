import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    var sum = 0
    while (scanner.hasNextInt()) {
        val nextInt = scanner.nextInt()
        if (nextInt == 0) break
        sum += nextInt
    }
    println(sum)
}