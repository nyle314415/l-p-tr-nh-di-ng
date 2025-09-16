package com.example.myapplication

import kotlinx.coroutines.*


fun main() = runBlocking {
    println(" Coroutine  ")

    // 1. Chạy một hàm tạm ngưng trong GlobalScope
    GlobalScope.launch {
        val output = getValue()
        println("Output from GlobalScope: $output")
    }

    // 2. Truy cập vào một Tác vụ coroutine
    val job: Job = GlobalScope.launch {
        val output = getValue()
        println("Output from job: $output")
    }

    // 3. Hủy một tác vụ coroutine
    job.cancel()
    println("Job cancelled: ${job.isCancelled}")

    // 4. Chạy một hàm tạm ngưng và chặn luồng hiện tại cho đến khi hàm này hoàn tất
    val blockingOutput = getValue()
    println("Output from runBlocking: $blockingOutput")

    // 5. Sử dụng async/await để trì hoãn hàm tạm ngưng
    val deferred: Deferred<Double> = async { getValue() }
    println("Output from async: ${deferred.await()}")

    // 6. Gọi một hàm tạm ngưng từ hàm tạm ngưng khác
    val processed = processValue()
    println("Output from processValue: $processed")

    println("\n=== Khác ===")

    // 7. Khai báo một đối tượng
    println("DataProviderManager singleton: $DataProviderManager")

    // 8. Phát hiện một ngoại lệ
    try {
        riskyOperation()
    } catch (exception: Exception) {
        println("Caught an exception: ${exception.message}")
    }

    // 9. Enum class example
    val direction = Direction.NORTH
    println("Enum direction = $direction")
    when (direction) {
        Direction.NORTH -> println("Going North")
        Direction.SOUTH -> println("Going South")
        Direction.WEST -> println("Going West")
        Direction.EAST -> println("Going East")
    }
}



// Khai báo hàm tạm ngưng
suspend fun getValue(): Double {
    delay(500) // Giả lập công việc lâu dài
    return 42.0
}

// Gọi hàm tạm ngưng từ hàm tạm ngưng khác
suspend fun processValue(): Double {
    val value = getValue()
    return value * 2 // ví dụ: nhân đôi giá trị
}

// Một hàm có thể gây ra ngoại lệ
fun riskyOperation() {
    throw Exception("This is a risky operation!")
}


object DataProviderManager

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}
