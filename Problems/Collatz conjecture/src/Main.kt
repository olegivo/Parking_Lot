import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    var n = scanner.nextInt()
    while (n != 1) {
        print("$n ")
        n = if (n % 2 == 0) {
            n / 2
        } else {
            n * 3 + 1
        }
    }
    print("$n")
}
