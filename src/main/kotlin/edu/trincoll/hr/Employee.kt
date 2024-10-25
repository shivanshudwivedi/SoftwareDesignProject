package edu.trincoll.hr

abstract class Employee(
    val name: String,
    val id: Int
) : Comparable<Employee> {

    abstract fun pay(): Double

    override fun compareTo(other: Employee): Int {
        // First compare based on pay
        val payComparison = this.pay().compareTo(other.pay())
        if (payComparison != 0) return payComparison

        // If pay is the same, compare by name
        val nameComparison = this.name.compareTo(other.name)
        if (nameComparison != 0) return nameComparison

        // If both pay and name are the same, compare by ID
        return this.id - other.id
    }

    override fun toString(): String {
        return "Employee(name='$name', id=$id)"
    }
}