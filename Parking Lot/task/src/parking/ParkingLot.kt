package parking

class ParkingLot {

    private val spots = (1..20).map { Spot(number = it) }

    fun processCommand(input: String): Boolean {
        val split = input.split(' ')
        val command = split.first().toLowerCase()
        val parameters = split.drop(1)
        when (command) {
            "park" -> park(parameters[0], parameters[1])
            "leave" -> leave(parameters.first().toInt())
            "exit" -> return false
        }
        return true
    }

    private fun park(regNumber: String, color: String) {
        getNotBusySpot()
                ?.park(Car(regNumber, color))
                ?: run { println("Sorry, the parking lot is full.") }
    }

    private fun leave(spotNumber: Int) {
        getSpot(spotNumber).leave()
    }

    private fun getNotBusySpot() = spots.firstOrNull { !it.isBusy }

    private fun getSpot(spotNumber: Int) = spots[spotNumber - 1]

    data class Spot(val number: Int, private var car: Car? = null) {
        val isBusy get() = car != null

        fun leave() {
            if (isBusy) {
                car = null
                println("Spot $number is free.")
            } else {
                println("There is no car in spot $number.")
            }
        }

        fun park(car: Car) {
            this.car = car
            println("${car.color} car parked in spot ${number}.")
        }
    }

    data class Car(val regNumber: String, val color: String)
}