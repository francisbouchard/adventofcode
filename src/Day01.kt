
fun main() {
    val input = readInput("input_day1")
    var count = 0
    input.forEachIndexed { index, element ->
        if(index > 0) {
            if((input[index-1].toInt()) < (element.toInt())) {
                count++
                }
        }
    }
    print(count)
}
