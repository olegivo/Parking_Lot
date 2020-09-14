package parking

import java.util.*

fun main() {
    val parkingLot = ParkingLot()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNextLine()) {
        val command = scanner.nextLine()
        if (!parkingLot.processCommand(command)) break
    }
}
