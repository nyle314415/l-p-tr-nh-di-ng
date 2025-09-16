package com.example.myapplication

fun main() {
    println("Hello, world!")
    println("This is the text to print!")


    //Biến
    val age = 5         // val: không thay đổi
    val name = "Rover"
    var roll = 6        // var: có thể thay đổi
    var rolledValue: Int = 4

    //In biến có mẫu chuỗi
    println("You are already ${age}!")
    println("You are already ${age} days old, ${name}!")

    //Loại dữ liệu
    val number: Int = 10
    val text: String = "Kotlin"
    val range: IntRange = 1..6
    val isFun: Boolean = true

    println("Number: $number, Text: $text, Range: $range, Boolean: $isFun")

    //Hàm không đối số
    fun printHello() {
        println("Hello Kotlin")
    }
    printHello()

    //Hàm có đối số
    fun printBorder(border: String, timesToRepeat: Int) {
        repeat(timesToRepeat) {
            print(border)
        }
        println()
    }
    printBorder("*", 10)

    //Hàm trả về giá trị
    fun roll(): Int {
        val randomNumber = (1..6).random()
        return randomNumber
    }

    val result = roll()
    println("Roll result: $result")

    //Toán tử
    val a = 10
    val b = 3
    println("a + b = ${a + b}")
    println("a - b = ${a - b}")
    println("a * b = ${a * b}")
    println("a / b = ${a / b}")

    //Toán tử logic
    if (a > b) println("a > b")
    if (a != b) println("a != b")

    //Số ngẫu nhiên
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    println("Random number: $randomNumber")

    //Vòng lặp repeat()
    fun printBorder2() {
        repeat(23) {
            print("=")
        }
        println()
    }
    printBorder2()

    //Lồng ghép vòng lặp
    fun printCakeBottom(age: Int, layers: Int) {
        repeat(layers) {
            repeat(age + 2) {
                print("@")
            }
            println()
        }
    }
    printCakeBottom(5, 3)

    //lệnh if/else
    val num = 4
    if (num > 4) {
        println("The variable is greater than 4")
    } else if (num == 4) {
        println("The variable is equal to 4")
    } else {
        println("The variable is less than 4")
    }

    //Câu lệnh when
    val luckyNumber = 3
    val rollResult = roll()
    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }

    //when gán cho biến
    val diceRoll = roll()
    val drawableResource = when (diceRoll) {
        1 -> "dice_1"
        2 -> "dice_2"
        3 -> "dice_3"
        4 -> "dice_4"
        5 -> "dice_5"
        else -> "dice_6"
    }
    println("Drawable resource: $drawableResource")

    // Lớp
    class Dice {
        var sides = 6

        fun roll() {
            val randomNumber = (1..6).random()
            println("Rolled a $randomNumber")
        }
    }

    class DiceWithSides(val numSides: Int) {
        fun roll(): Int {
            val randomNumber = (1..numSides).random()
            return randomNumber
        }
    }

    fun main() {
        val myFirstDice = Dice()
        myFirstDice.roll()

        val mySecondDice = DiceWithSides(6)
        println("Rolled a 12-sided dice: ${mySecondDice.roll()}")
    }
}



