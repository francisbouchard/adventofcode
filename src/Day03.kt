fun main() {
    val input = readInput("input_day3")
    val length = input[0].length //length of number
    var gamma = ""
    var epsilon = ""
    var count: MutableMap<Int, Int> = mutableMapOf()
    repeat(length) { index -> //initialize count
        count[index] = 0
    }
    input.forEach { element ->
        element.toCharArray().forEachIndexed { index, c ->
            val set = if (c == '1') 1 else -1
            count[index] = count[index]?.plus(set) as Int
        }
    }
    count.forEach{ (_, v) ->
           if(v>0) {
               gamma += "1"
               epsilon += "0"
           } else {
               gamma += "0"
               epsilon += "1"
           }
    }
    val gammaValue = gamma.toInt(2)
    val epsilonValue = epsilon.toInt(2)
    print(gammaValue*epsilonValue)
}
