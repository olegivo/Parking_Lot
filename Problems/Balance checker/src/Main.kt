import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    var balance = scanner.nextInt()
    var purchases = 0
    while (scanner.hasNextInt()) {
        val purchase = scanner.nextInt()
        purchases += purchase
        if (purchase > balance) {
            println("Error, insufficient funds for the purchase. You have $balance, but you need $purchase.")
            break
        }
        balance -= purchase
        if (!scanner.hasNextInt()) {
            println("Thank you for choosing us to manage your account! You have $balance money.")
        }
    }
}