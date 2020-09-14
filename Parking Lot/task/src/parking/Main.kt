package parking

import java.util.*

fun main() {
    var parkingLot: ParkingLot? = null
    val scanner = Scanner(System.`in`)
    loop@ while (scanner.hasNextLine()) {
        val split = scanner.nextLine().split(' ')
        val command = split.first().toLowerCase()
        val parameters = split.drop(1)
        when (command) {
            "create" -> parkingLot = ParkingLot.create(parameters.first().toInt())
            "status" -> parkingLot?.status().orError()
            "park" -> parkingLot?.park(parameters[0], parameters[1]).orError()
            "leave" -> parkingLot?.leave(parameters.first().toInt()).orError()
            "exit" -> break@loop
        }
    }

}

private fun Unit?.orError() {
    if (this == null) {
        println("Sorry, a parking lot has not been created.")
    }
}
