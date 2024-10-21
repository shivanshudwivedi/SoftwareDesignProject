package edu.trincoll.hr

class Salaried(
    name: String,
    id: Int,
    val salary: Double
) : Employee(name, id) {

    override fun pay(): Double {
        return salary / 26.0 // Assuming biweekly pay
    }

    override fun toString(): String {
        return "Salaried(name='$name', id=$id, salary=$salary)"
    }
}
