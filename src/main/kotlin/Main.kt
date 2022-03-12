fun main() {
    print("Введите целым числом кол-во секунд, когда абонент был в сети: ")
    val number = readLine()?.toInt() ?: return
    println("Абонент был(а) в сети ${agoToText(number)}")
}

fun agoToText(secNumber: Int): String {
    return when (secNumber) {
        in 0..60 -> "только что"
        in 61..3600 -> {
            val tempMin = secNumber / 60
            val lastFigure: Char = tempMin.toString().last()
            if (tempMin in 10..20) "$tempMin минут назад" else when (lastFigure.digitToInt()) {
                0 -> "$tempMin минут"
                1 -> "$tempMin минуту"
                in 2..4 -> "$tempMin минуты"
                in 5..9 -> "$tempMin минут"
                else -> "$tempMin минут"
            } + " назад"
        }
        in 3601..86400 -> {
            val tempHour = secNumber / 3600
            val lastFigure: Char = tempHour.toString().last()
            if (tempHour in 10..20) "$tempHour часов назад" else when (lastFigure.digitToInt()) {
                0 -> "$tempHour часов"
                1 -> "$tempHour час"
                in 2..4 -> "$tempHour часа"
                in 5..9 -> "$tempHour часов"
                else -> "$tempHour час"
            } + " назад"
        }
        in 86401..172800 -> "сегодня"
        in 172801..259200 -> "вчера"
        else -> {
            "давно"
        }
    }
}

