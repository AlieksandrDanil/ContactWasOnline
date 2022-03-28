const val MINUTE = 60
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
const val TWO_DAYS = 2 * DAY
const val THREE_DAYS = 3 * DAY

fun main() {
    print("Введите целым числом кол-во секунд, когда абонент был в сети: ")
    val sec = readLine()?.toInt() ?: return
        println("Собеседник был(а) в сети ${agoToText(sec)}")
}

fun agoToText(sec: Int): String {
    return if (sec < MINUTE) "только что"
    else if (sec < HOUR) {
        val minutes = sec / MINUTE
        val minutesPlural = plural(minutes, one = "минуту", few = "минуты", many = "минут")
        "$minutes $minutesPlural назад"
    } else if (sec < DAY) {
        val hours = sec / HOUR
        val hoursPlural = plural(hours, one = "час", few = "часа", many = "часов")
        "$hours $hoursPlural назад"
    } else if (sec < TWO_DAYS) {
        "сегодня"
    } else if (sec < THREE_DAYS) {
        "вчера"
    } else {
        "давно"
    }
}

fun plural(amount: Int, one: String, few: String, many: String): String {
    val reminder10 = amount % 10
    val reminder100 = amount % 100
    return when {
        reminder100 in 11..20 -> many
        reminder10 == 1 -> one
        reminder10 in 2..4 -> few
        else -> many
    }
}

