fun main() {
    var input = readInput("input_day4")
    val numbers = input[0]

    var mutableList = input.toMutableList()
    mutableList.removeAt(0)
    mutableList.removeAt(0)

    var cards = mutableListOf<List<MutableMap<Int, Boolean>>>()
    var row = mutableMapOf<Int, Boolean>()
    var card = mutableListOf<MutableMap<Int, Boolean>>()
    mutableList.forEach {
        if (it.isEmpty()) {
            var cardToAdd = mutableListOf<MutableMap<Int, Boolean>>()
            cardToAdd.addAll(card)
            cards.add(cardToAdd)
            card.clear()
            return@forEach
        }

        it.split(" ").forEach { cell ->
            if(cell.isNotEmpty()) {
                row[cell.toInt()] = false
            }
        }
        val cardToAdd = mutableMapOf<Int, Boolean>()
        cardToAdd.putAll(row)
        card.add(cardToAdd)
        row.clear()
    }
    var drawn = mutableListOf<Int>()
    numbers.split(",").map { it.toInt() }.forEach { draw ->
        drawn.add(draw)

        cards.forEach { card ->
            var winner: Int? = null
            //column check
            repeat(5) { columnIndex ->
                var column = card[columnIndex]
                column.keys.forEach { cell ->
                    if(drawn.contains(cell)) {
                        column[cell] = true
                    }
                }
                if (!column.values.contains(false)) {
                    winner = draw
                }
            }
            //row check
            repeat(5) { rowIndex ->
                var row = mutableMapOf<Int, Boolean>()
                repeat(5) {
                    row = card[rowIndex]
                }
                row.keys.forEach { cell ->
                    if(drawn.contains(cell)) {
                        row[cell] = true
                    }
                }
                if (!row.values.contains(false)) {
                    winner = draw
                }
            }

            if (winner != null) {
                var sum = 0
                repeat(5) { column ->
                    var keys = card[column].filterValues { !it }.keys
                    sum += keys.sum()

                }
                print(sum*draw)
            }

        }


    }


}