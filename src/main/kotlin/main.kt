fun main() {
    println(agoToText(14400))
}

fun agoToText(secondsAgo: Int) = when (secondsAgo) {
    in 0..60 -> "был(а) только что"
    in 61..60 * 60 -> secToMin(secondsAgo)
    in 60 * 60 + 1..24 * 60 * 60 -> secToHour(secondsAgo)
    in 24 * 60 * 60 + 1..48 * 60 * 60 -> "был(а) в сети сегодня"
    in 48 * 60 * 60 + 1..72 * 60 * 60 -> "был(а) в сети вчера"
    else -> "был(а) в сети давно"
}

fun secToMin(secondsAgo: Int): String {
    val secInMinute = 60
    val minutes: Int = secondsAgo / secInMinute
    val writeMinutes: String = when {
        minutes in 11..20 -> "минут"
        minutes % 10 == 1 -> "минуту"
        minutes % 10 == 2 -> "минуты"
        minutes % 10 == 3 -> "минуты"
        minutes % 10 == 4 -> "минуты"
        else -> "минут"
    }
    return "был(а) в сети $minutes $writeMinutes назад"
}

fun secToHour(secondsAgo: Int): String {
    val secInHour = 60 * 60
    val hours: Int = secondsAgo / secInHour
    val writeHours: String = when (hours) {
        1 -> "час"
        in 2..4 -> "часа"
        21 -> "час"
        in 22..23 -> "часа"
        else -> "часов"
    }
    return "был(а) в сети $hours $writeHours назад"
}