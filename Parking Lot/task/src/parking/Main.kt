package parking

import java.util.*

fun main() {
    val parkingLot = ParkingLot()
    val scanner = Scanner(System.`in`)
    loop@ while (scanner.hasNextLine()) {
        val split = scanner.nextLine().split(' ')
        val command = split.first().toLowerCase()
        val parameters = split.drop(1)
        when (command) {
            "park" -> parkingLot.park(parameters[0], parameters[1])
            "leave" -> parkingLot.leave(parameters.first().toInt())
            "exit" -> break@loop
        }
    }

}
