const val SEC_NOW_FROM = 0
const val SEC_NOW_TILL = 59
const val SEC_MIN_FROM = 60
const val SEC_MIN_TILL = 3599
const val SEC_HOUR_FROM = 3600
const val SEC_HOUR_TILL = 86399
const val SEC_TODAY_FROM = 86400
const val SEC_TODAY_TILL = 172799
const val SEC_YESTERDAY_FROM = 172800
const val SEC_YESTERDAY_TILL = 259199

fun main() {
    print("Введите целым числом кол-во секунд, когда абонент был в сети: ")
    val number = readLine()?.toInt() ?: return
        println("Собеседник был(а) в сети ${agoToText(number)}")
}

fun agoToText(sec: Int): String = when (sec) {
    in SEC_NOW_FROM..SEC_NOW_TILL -> "только что"
    in SEC_MIN_FROM..SEC_MIN_TILL -> {
        val tempMin = sec / 60
        plural(tempMin,true)
    }
    in SEC_HOUR_FROM..SEC_HOUR_TILL -> {
        val tempHour = sec / 3600
        plural(tempHour,false)
    }
    in SEC_TODAY_FROM..SEC_TODAY_TILL -> "сегодня"
    in SEC_YESTERDAY_FROM..SEC_YESTERDAY_TILL -> "вчера"
    else -> {
        "давно"
    }
}

fun plural(secToMinHour: Int, boolMinTrueHourFalse: Boolean): String {
    return "${
        when {
            secToMinHour in 11..20 -> if (boolMinTrueHourFalse) "$secToMinHour минут"
                else "$secToMinHour часов"
            secToMinHour % 10 == 1 -> if (boolMinTrueHourFalse) "$secToMinHour минуту"
                else "$secToMinHour час"
            secToMinHour % 10 in 2..4 -> if (boolMinTrueHourFalse) "$secToMinHour минуты"
                else "$secToMinHour часа"
            else -> if (boolMinTrueHourFalse) "$secToMinHour минут"
                else "$secToMinHour часов"
        }
    } назад"
}

