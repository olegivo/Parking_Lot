package parking

class ParkingLot(spots: Int) {

    private val spots = (1..spots).map { Spot(number = it) }

    fun status() {
        var isEmpty = true
        spots.forEach { spot ->
            if (spot.isBusy) {
                isEmpty = false
                println(spot)
            }
        }
        if (isEmpty) {
            println("Parking lot is empty.")
        }
    }

    fun regByColor(color: String) {
        val result = spots.mapNotNull { it.car }
                .filter { it.color.equals(color, true) }
                .map { it.regNumber }
        if (result.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(result.joinToString())
        }
    }

    fun spotByColor(color: String) {
        val result = spots.filter { it.car?.color.equals(color, true) }
                .map { it.number }
        if (result.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(result.joinToString())
        }
    }

    fun spotByReg(reg: String) {
        val result = spots.filter { it.car?.regNumber.equals(reg, true) }
                .map { it.number }
        if (result.isEmpty()) {
            println("No cars with registration number $reg were found.")
        } else {
            println(result.joinToString())
        }
    }

    fun park(regNumber: String, color: String) {
        getNotBusySpot()
                ?.park(Car(regNumber, color))
                ?: run { println("Sorry, the parking lot is full.") }
    }

    fun leave(spotNumber: Int) {
        getSpot(spotNumber).leave()
    }

    private fun getNotBusySpot() = spots.firstOrNull { !it.isBusy }
    private fun getSpot(spotNumber: Int) = spots[spotNumber - 1]

    companion object {
        fun create(spots: Int): ParkingLot {
            println("Created a parking lot with $spots spots.")
            return ParkingLot(spots)
        }
    }

    data class Spot(val number: Int, var car: Car? = null) {
        val isBusy get() = car != null

        override fun toString(): String = buildString {
            append(number)
            car?.let { append(" $it") }
        }

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

    data class Car(val regNumber: String, val color: String) {
        override fun toString(): String = "$regNumber $color"
    }
}