package com.example.myapplication

fun main() {
    println("=== 1. Set (Tập hợp) ===")
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println("Set từ danh sách: $setOfNumbers")

    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)
    println("Giao nhau: ${set1.intersect(set2)}")
    println("Hợp: ${set1.union(set2)}")

    println("\n=== 2. Map (Sơ đồ / Từ điển) ===")
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    println("Duyệt map:")
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()

    println("Map -> String:")
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", "))

    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println("Lọc theo tên ngắn (<4): $filteredNames")

    println("\n=== 3. Phép toán khác trên List ===")
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
    println("Danh sách sau khi lọc/xáo/take/sắp xếp: $filteredWords")

    println("\n=== 4. Scope Functions ===")
    val arguments: Map<String, String>? = mapOf("LETTER" to "A")
    arguments?.let {
        val letterId = it.get("LETTER").toString()
        println("Giá trị lấy bằng let: $letterId")
    }

    data class Binding(var flavorFragment: String? = null)
    val binding = Binding()
    binding.apply {
        flavorFragment = "FlavorFragment"
    }
    println("Sau apply: ${binding.flavorFragment}")

    println("\n=== 5. Khác ===")
    // Backing property
    val wordWrapper = WordWrapper()
    println("Backing property: ${wordWrapper.currentScrambledWord}")

    // Safe call
    val intentExtras: Map<String, String>? = mapOf("letter" to "B")
    val letterId = intentExtras?.get("letter").toString()
    println("Safe call ?: $letterId")

    // Lambda
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println("Lambda triple(5) = ${triple(5)}")

    // Companion object
    println("Companion object: ${DetailActivity.LETTER}")

    // Elvis operator
    var quantity: Int? = null
    println("quantity ?: 0 = ${quantity ?: 0}")
    quantity = 4
    println("quantity ?: 0 = ${quantity ?: 0}")

    // Lateinit example
    val game = Game()
    game.initWord("Kotlin")
    println("Lateinit word: ${game.currentWord}")
}

// Backing property demo class
class WordWrapper {
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord
}

// Companion object demo
class DetailActivity {
    companion object {
        const val LETTER = "letter"
    }
}

// Lateinit demo
class Game {
    private lateinit var _currentWord: String
    val currentWord: String
        get() = _currentWord

    fun initWord(word: String) {
        _currentWord = word
    }
}
