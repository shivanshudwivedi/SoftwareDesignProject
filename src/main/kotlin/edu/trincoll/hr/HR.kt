package edu.trincoll.hr

class HR(private val employees: List<Employee> = emptyList()) {

    fun hire(employee: Employee): HR {
        return HR(employees + employee)
    }

    fun fire(id: Int): HR {
        return HR(employees.filter { it.id != id })
    }

    fun payEmployees(): Double {
        return employees.sumOf { it.pay() }
    }

    override fun toString(): String {
        return "HR(employees=$employees)"
    }
}
