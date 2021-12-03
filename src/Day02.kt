fun main() {
    val input = readInput("input_day2")
    var depth = 0
    var dist = 0
    input.forEach { element ->
        val move = element.split(" ")
        if (move[0] == "forward") dist += move[1].toInt()
        if (move[0] == "down") depth += move[1].toInt()
        if (move[0] == "up") depth -= move[1].toInt()
    }
    print(depth*dist)
}