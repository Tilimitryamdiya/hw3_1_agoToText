fun main() {
    println(agoToText(14400))
}

fun agoToText(secondsAgo: Int) = when (secondsAgo) {
    in 0..60 -> "���(�) ������ ���"
    in 61..60 * 60 -> secToMin(secondsAgo)
    in 60 * 60 + 1..24 * 60 * 60 -> secToHour(secondsAgo)
    in 24 * 60 * 60 + 1..48 * 60 * 60 -> "���(�) � ���� �������"
    in 48 * 60 * 60 + 1..72 * 60 * 60 -> "���(�) � ���� �����"
    else -> "���(�) � ���� �����"
}

fun secToMin(secondsAgo: Int): String {
    val secInMinute = 60
    val minutes: Int = secondsAgo / secInMinute
    val writeMinutes: String = when {
        minutes in 11..20 -> "�����"
        minutes % 10 == 1 -> "������"
        minutes % 10 == 2 -> "������"
        minutes % 10 == 3 -> "������"
        minutes % 10 == 4 -> "������"
        else -> "�����"
    }
    return "���(�) � ���� $minutes $writeMinutes �����"
}

fun secToHour(secondsAgo: Int): String {
    val secInHour = 60 * 60
    val hours: Int = secondsAgo / secInHour
    val writeHours: String = when (hours) {
        1 -> "���"
        in 2..4 -> "����"
        21 -> "���"
        in 22..23 -> "����"
        else -> "�����"
    }
    return "���(�) � ���� $hours $writeHours �����"
}