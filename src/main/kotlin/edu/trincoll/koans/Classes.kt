package edu.trincoll.koans

// Data classes
data class Person(val name: String, val age: Int)

fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}

fun comparePeople(): Boolean {
    val p1 = Person("Alice", 29)
    val p2 = Person("Alice", 29)
    return p1 == p2  // should be true
}

// Smart casts
sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun evalSmartCasts(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value  // If it's a Num, return its value
        is Sum -> evalSmartCasts(expr.left) + evalSmartCasts(expr.right)  // Recursively evaluate left and right sums
        else -> throw IllegalArgumentException("Unknown expression")
    }

// Sealed classes
fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value  // If it's a Num, return its value
        is Sum -> eval(expr.left) + eval(expr.right)  // Recursively evaluate left and right sums
        else -> throw IllegalArgumentException("Unknown expression")
    }

// Rename on import
import kotlin.random.Random as KRandom
import java.util.Random as JRandom

fun useDifferentRandomClasses(): String {
    return "Kotlin random: " +
            KRandom.nextInt(2) +  // Generates a number between 0 and 1
            " Java random: " +
            JRandom().nextInt(2) +  // Generates a number between 0 and 1
            "."
}

// Extension functions
fun Int.r(): RationalNumber = RationalNumber(this, 1)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(this.first, this.second)

data class RationalNumber(val numerator: Int, val denominator: Int)
